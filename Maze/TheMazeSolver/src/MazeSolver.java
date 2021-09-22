
public abstract class MazeSolver
{

	private Maze maze;
	private boolean impossible = false;
	private String path = "";
	public Square[][] mazeArray;
	int counter = 0;

	/**
	 * Constructor that uses maze as a parameter called from MazeSolveStack adds
	 * start to the maze, sets a array version of maze
	 * 
	 * @param maze
	 */
	MazeSolver(Maze maze)
	{
		this.maze = maze;
		this.makeEmpty();
		this.add(maze.getStart());
		mazeArray = maze.getMazeArray();

	}

	/**
	 * Returns true if the Exit square is in the worklist true then update the
	 * status of all previous squares
	 */
	public boolean isSolved()
	{
		if (maze.getExit().getSquarePrevious() == null)
		{
			return false;
		} else if (isAllWorked())
		{
			impossible = true;
			return true;
		} else
		{
			Square s = maze.getExit().getSquarePrevious();
			while (s.getType() != 2 && s.getType() != 1)
			{
				s.setStatus('x');
				s = s.getSquarePrevious();
			}
			return true;
		}

	}

	/**
	 * private method I made in order to tempt to solve the issue when the program
	 * does not display a maze is impossible it works by checking if any items are
	 * still in the worklist returns true if there is nothing with a status of 'o'
	 * 
	 * @return true if there are no possible routes
	 */
	private boolean isAllWorked()
	{
		for (int r = 0; r < maze.getRows(); r++)
		{
			for (int c = 0; c < maze.getCols(); c++)
			{
				if (mazeArray[r][c].getStatus() == 'o')
				{
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * goes through one step of our solving algorithm by doing steps 1-5 on the
	 * instructions
	 */
	public void step()
	{

		if (isEmpty())
		{
			impossible = true;
			return;
		}
		Square s = this.next();
		if (s == maze.getExit() || s == null)
		{
			impossible = true;
			return;
		}
		if (s != null)
		{
			for (Square n : maze.getNeighbors(s))
			{
				if (!n.isMarked() && n != maze.getStart())
				{
					n.setSquarePrevious(s);
				}
				if (n.getType() == 3)
				{
					return;
				} else
				{
					n.setStatus('o');
					add(n);
				}
			}
		}
		if (s.getStatus() == 'o')
		{
			s.setStatus('.');// updates the squares status as it will be popped
		}

		return;
	}

	/**
	 * iterates through the array and if the square should be on the exit path it
	 * adds it to a string and returns it
	 * 
	 * @return exit path
	 */
	public String getPath()
	{
		path = "";
		if (isSolved())
		{
			for (int r = 0; r < maze.getRows(); r++)
			{
				for (int c = 0; c < maze.getCols(); c++)
				{
					if (mazeArray[r][c].getStatus() == 'x')
					{
						path += "[" + r + ", " + c + "]";
					}
				}
			}
			return path;
		} else
		{
			return "This maze is impossible";
		}
	}

	/**
	 * Calls step() while the maze is not solved or is determined to be impossible
	 */
	public void solve()
	{
		while (isSolved() != true)
		{
			this.step();
			if(isEmpty())
			{
				System.out.println(getPath());
				break;
			}
			if (impossible)
			{
				System.out.println(getPath());
				break;
			}
		}
		
	}

	// abstract methods
	abstract void makeEmpty();

	abstract boolean isEmpty();

	abstract void add(Square s);

	abstract Square next();

}