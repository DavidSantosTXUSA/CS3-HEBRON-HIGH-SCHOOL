import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Maze
{
	// this class will store values of location
	Location[][] maze;// 2d array representation of the maze
	private int rows;// rows of the maze
	private int cols;// columns of the maze
	private Location start;// start location
	private Location exit;// exit location
	Queue<Location> q;

	/**
	 * default constructor intializes the datatypes and the maze we will use
	 */
	public Maze()
	{
		q = new LinkedList<Location>();
		maze = new Location[0][0];
	}

	/**
	 * loads the file into the maze
	 * 
	 * @param fileName
	 * @return true if it works, false if a error occurs
	 */
	public boolean loadMaze(String fileName)
	{
		try
		{
			Scanner key = new Scanner(new File(fileName));
			rows = key.nextInt();
			cols = key.nextInt();
			maze = new Location[rows][cols];
			

			for (int r = 0; r < rows; r++)
			{
				for (int c = 0; c < cols; c++)
				{
					
					maze[r][c] = new Location(r, c, key.nextInt());
					
				}
			}
			int x1 = key.nextInt();
			int y1 = key.nextInt();
			int x2 = key.nextInt();
			int y2 = key.nextInt();
			maze[x1][y1].setIsStart(true);
			maze[x2][y2].setIsExit(true);
			start = maze[x1][y1];
			exit = maze[x2][y2];

			return true;

		} catch (FileNotFoundException e)
		{
			return false;
		}

	}

	public void solve()
	{
		solve(getStart(), getExit(), maze);
	}

	/**
	 * This method will attempt to solve the maze with the shortest path possible
	 * using BFS , while it does use BFS it does not find the shortest amount of
	 * steps for a maze, although it does succeed at determining if a maze is
	 * impossible, and it will find a solution, although its not optimal at all, it
	 * can be off a few steps or by dozens.
	 * 
	 * @param start
	 * @param end
	 * @param maze2
	 */
	private void solve(Location start, Location end, Location[][] maze2)
	{
		int check = 0;// used as a checker for if we find the exit mid loop
		start.setIsVisited(true);
		end.setIsVisited(true);
		q.add(start);// add the start to the queue

		while (!q.isEmpty() && check == 0)
		{
			Location l = q.poll();// pop off the queue

			if (l.isExit())// if we found the exit then we are done
			{
				break;
			}
			if (check == 0)
			{
				for (int j = l.getCols() + 1; j >= l.getCols() - 1; j--)
				{
					if (j >= 0 && j < getCols() && maze[l.getRows()][j].getType() == 1
							&& maze[l.getRows()][j].isVisited() == false)// if in bounds and type is empty and not
																			// visited, we add to queue
					{
						q.add(maze[l.getRows()][j]);
						maze[l.getRows()][j].setIsVisited(true);
						maze[l.getRows()][j].setPreviousLocation(l);

					} else if (j >= 0 && j < getRows())// if in bounds but not a empty
					{
						maze[l.getRows()][j].setIsVisited(true);// still set it to visited just in case idk i was trying
																// to optimize
						if (maze[l.getRows()][j].equals(end))// if we found exit we done
						{
							maze[l.getRows()][j].setPreviousLocation(l);
							check = 1;
							break;
						}
					}
				}
			}
			// same idea here except this checks up and down
			if (check == 0)
			{
				for (int i = l.getRows() + 1; i >= l.getRows() - 1; i--)
				{
					if (i >= 0 && i < getRows() && maze[i][l.getCols()].getType() == 1
							&& maze[i][l.getCols()].isVisited() == false)
					{
						q.add(maze[i][l.getCols()]);
						maze[i][l.getCols()].setIsVisited(true);
						maze[i][l.getCols()].setPreviousLocation(l);

					} else if (i >= 0 && i < getRows())
					{
						maze[i][l.getCols()].setIsVisited(true);
						if (maze[i][l.getCols()].equals(end))// if we found exit we done
						{
							maze[i][l.getCols()].setPreviousLocation(l);
							check = 1;
							break;
						}
					}
				}
			}
			// System.out.println(l.getCoordinates());//used for debugging
		}
		if (check == 0)// if check is 0 it means we never found exit so we print out -1
		{
			System.out.println(-1);
		} else
		{
			int count = 0;
			Location b = getExit();
			while (b.getPrevious() != null)
			{
				b = b.getPrevious();
				count++;
			}
			count++;
			System.out.println(count - 1);
		}
	}

	/**
	 * returns the exit of the maze
	 * 
	 * @return exit
	 */
	public Location getExit()
	{
		return exit;
	}

	/**
	 * returns the start of the maze
	 * 
	 * @return start
	 */
	public Location getStart()
	{
		return start;
	}

	/**
	 * returns the rows
	 * 
	 * @return rows
	 */
	public int getRows()
	{
		return rows;
	}

	/**
	 * returns the columns
	 * 
	 * @return cols
	 */
	public int getCols()
	{
		return cols;
	}

	/**
	 * Overidden toString() method prints out the maze[][] in a readable way
	 */
	@Override
	public String toString()
	{
		String output = "";
		for (int r = 0; r < rows; r++)
		{
			for (int c = 0; c < cols; c++)
			{
				output += maze[r][c].toString() + " ";
			}
			output += "\n";
		}

		return output;
	}
}
