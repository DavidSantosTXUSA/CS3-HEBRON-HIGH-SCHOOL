import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Maze
{
	Square[][] maze;
	private int rows;
	private int cols;
	private Square start;
	private Square exit;

	/**
	 * Constructor for maze Sets maze to a default size
	 */
	public Maze()
	{
		maze = new Square[0][0];
	}

	/**
	 * Loads the maze returns true if it reads the file without error uses a try
	 * catch block to catch a no file exception sets start and exit equal to the
	 * correct values on the maze and then prints out a toString of the maze
	 * 
	 * @param fileName
	 * @return true if file exists
	 */
	public boolean loadMaze(String fileName)
	{
		try
		{
			Scanner key = new Scanner(new File(fileName));
			rows = key.nextInt();
			cols = key.nextInt();
			maze = new Square[rows][cols];
			while (key.hasNext())
			{
				for (int r = 0; r < rows; r++)
				{
					for (int c = 0; c < cols; c++)
					{
						maze[r][c] = new Square(r, c, key.nextInt());
						if (maze[r][c].toString() == "S")
						{
							start = maze[r][c];
						}
						if (maze[r][c].toString() == "E")
						{
							exit = maze[r][c];
						}
					}
				}
				System.out.println(maze.toString());

			}
			return true;

		} catch (FileNotFoundException e)
		{
			return false;
		}

	}

	/**
	 * Returns the value of exit
	 */
	public Square getExit()
	{
		return exit;
	}

	/**
	 * Only adds empty spaces and the exit to the list does not add the start of the
	 * array since we already added it does not add any items we have explored
	 * already
	 * 
	 * @param Square s
	 * @return List of neighboring squares
	 */
	public List<Square> getNeighbors(Square s)
	{
		ArrayList<Square> list = new ArrayList<Square>();

		// checks down
		if (s != null && s.getRows() + 1 < rows)
		{
			if (maze[s.getRows() + 1][s.getCols()].getType() == 0 || maze[s.getRows() + 1][s.getCols()].getType() == 3) //checks if the type is empty or exit
			{
				if (maze[s.getRows() + 1][s.getCols()].isMarked() == false)//makes sure its not in the worklist already
				{
					list.add(maze[s.getRows() + 1][s.getCols()]);//adds
				}

			}
		}
		// checks right
		if (s != null && s.getCols() + 1 < cols)
		{
			if (maze[s.getRows()][s.getCols() + 1].getType() == 0 || maze[s.getRows()][s.getCols() + 1].getType() == 3)
			{
				if (maze[s.getRows()][s.getCols() + 1].isMarked() == false)
				{
					list.add(maze[s.getRows()][s.getCols() + 1]);
				}

			}
		}
		// checks left
		if (s != null && s.getCols() - 1 >= 0)
		{
			if (maze[s.getRows()][s.getCols() - 1].getType() == 0 || maze[s.getRows()][s.getCols() - 1].getType() == 3)
			{
				if (maze[s.getRows()][s.getCols() - 1].isMarked() == false)
				{
					list.add(maze[s.getRows()][s.getCols() - 1]);
				}
			}
		}
		// checks up
		if (s != null && s.getRows() - 1 >= 0)
		{
			if (maze[s.getRows() - 1][s.getCols()].getType() == 0 || maze[s.getRows() - 1][s.getCols()].getType() == 3)
			{
				if (maze[s.getRows() - 1][s.getCols()].isMarked() == false)
				{
					list.add(maze[s.getRows() - 1][s.getCols()]);
				}
			}
		}

		return list;
	}

	/**
	 * Resets the maze to the way it was when first loaded by calling the
	 * resetType() method for every cell
	 */
	public void reset()
	{
		for (int r = 0; r < rows; r++)
		{
			for (int c = 0; c < cols; c++)
			{
				maze[r][c].resetType();
			}
		}
	}

	/**
	 * Return start
	 * 
	 * @return start
	 */
	public Square getStart()
	{
		return start;
	}

	/**
	 * returns the maze
	 * 
	 * @return maze
	 */
	public Square[][] getMazeArray()
	{
		return maze;
	}

	/**
	 * returns the number of rows on the maze
	 * 
	 * @return rows
	 */
	public int getRows()
	{
		return rows;
	}

	/**
	 * returns the number of columns on the maze
	 * 
	 * @return columns
	 */
	public int getCols()
	{
		return cols;
	}

	public String toString()
	{
		String output = "";
		for (int r = 0; r < rows; r++)
		{
			for (int c = 0; c < cols; c++)
			{
				output += maze[r][c].toString();
			}
			output += "\n";
		}

		return output;
	}
}
