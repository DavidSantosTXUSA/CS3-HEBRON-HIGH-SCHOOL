import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;
import javax.swing.Timer;

public class LifeModel implements ActionListener
{

	/*
	 *  This is the Model component.
	 */

	private static int SIZE = 60;
	private LifeCell[][] grid;
	
	LifeView myView;
	Timer timer;

	/** Construct a new model using a particular file */
	public LifeModel(LifeView view, String fileName) throws IOException
	{       
		int r, c;
		grid = new LifeCell[SIZE][SIZE];
		for ( r = 0; r < SIZE; r++ )
			for ( c = 0; c < SIZE; c++ )
				grid[r][c] = new LifeCell();

		if ( fileName == null ) //use random population
		{                                           
			for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
		}
		else
		{                 
			Scanner input = new Scanner(new File(fileName));
			int numInitialCells = input.nextInt();
			for (int count=0; count<numInitialCells; count++)
			{
				r = input.nextInt();
				c = input.nextInt();
				grid[r][c].setAliveNow(true);
			}
			input.close();
		}

		myView = view;
		myView.updateView(grid);

	}

	/** Constructor a randomized model */
	public LifeModel(LifeView view) throws IOException
	{
		this(view, null);
	}

	/** pause the simulation (the pause button in the GUI */
	public void pause()
	{
		timer.stop();
	}
	
	/** resume the simulation (the pause button in the GUI */
	public void resume()
	{
		timer.restart();
	}
	
	/** run the simulation (the pause button in the GUI */
	public void run()
	{
		timer = new Timer(50, this);
		timer.setCoalesce(true);
		timer.start();
	}

	/** called each time timer fires */
	public void actionPerformed(ActionEvent e)
	{
		oneGeneration();
		myView.updateView(grid);
	}

  //Inbounds method should take in two values that represent the coordinates of a 2D array
  //and check if it is inside the 60x60 array in order to prevent out of bounds errors
  //@Param row and column
  //@Return true if inside the 2D array and will not result in a index error
  private boolean inBounds(int r, int c)//checks if inbounds
	{
		if(r==-1 || c==-1 || r == 60 || c == 60)
			return false;
		else
			return true;
	}
 
  //The count cells method will count alive neighboring cells in a 3 by 3 area from 
  //the midpoint x and y from the 2D array given in the @Param
  //@Param the 2d array, x coordinate, y coordinate
  //@Return how many cells are alive in the 3 by 3 area
  private int countCells(LifeCell[][] temp, int x, int y)
  {
      int sum = 0;
      for(int i = x-1; i<=x+1; i++)
      {
        for(int j = y-1; j<=y+1; j++)
        {
            if(inBounds(i,j))
            {
              if(temp[i][j].isAliveNow())
              {
                  sum++;
              }
            }
        }
      }
      if(temp[x][y].isAliveNow())
      {
        sum--;
      }      
      return sum;
  }
	/** main logic method for updating the state of the grid / simulation */
	private void oneGeneration()
	{
		/* 
		 * student code here 
		 */
     //one down = j+1,  one up is j-1;
     //one right is i+1, one left is i-1,
     //down right = j+1 , i+1: down left = j+1 , i-1
     //up right = j-1, i+1: up left = j-1, i-1
     int cells = 0;
     LifeCell[][] future = grid;//future grid which we will use to determine the next gen then copy it to the current one
     //because if we just changed grid , it wouldnt have a accurate outcome because it would update row by row rather then all at once
     for(int i = 0; i<60; i++)//rows
     {
       for(int j = 0; j<60; j++)//col
       {
       
            cells = countCells(grid, i, j);
            //System.out.println(cells); //debugger line
            if(cells == 2)
            {
            	if(grid[i][j].isAliveNow())
            	{
            		future[i][j].setAliveNext(true);
            	}else
            	{
            		future[i][j].setAliveNext(false);
            	}
            }
            if(cells == 3)
            {
            	if(grid[i][j].isAliveNow())
            	{
            		future[i][j].setAliveNext(true);
            	}else 
            	{
            		future[i][j].setAliveNow(true);
            	}
            	
            }
            if(cells !=2 && cells !=3)
            {
            	if(grid[i][j].isAliveNow())
            	{
            		future[i][j].setAliveNow(false);
            	}else 
            	{
            		future[i][j].setAliveNext(false);
            	}
            }
            
         }
           
      }
     grid = future;//updates
	}
}