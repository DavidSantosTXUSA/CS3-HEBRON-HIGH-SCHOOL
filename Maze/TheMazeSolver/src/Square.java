public class Square
{
	// values used to determine what type of square this is
	public final static int EMPTY = 0;
	public final static int WALL = 1;
	public final static int START = 2;
	public final static int EXIT = 3;

	// values used to determine the status of a square while being solved
	public final static char WORKING = 'o';
	public final static char WORKED = '.';
	public final static char EXIT_PATH = 'x';
	public final static char UNCHARTED = ' ';

	private int row, col;
	private int type;
	private char status;
	private Square squarePrevious;//used to make a path back to the start

	/**
	 * Constructor that sets row, col, and type to their correct values sets
	 * squarePrevious to null
	 * 
	 * @param row
	 * @param col
	 * @param type
	 */
	public Square(int row, int col, int type)
	{
		this.row = row;
		this.col = col;
		this.type = type;
		this.status = UNCHARTED;
		squarePrevious = null;
	}

	/**
	 * Returns the amount of rows in the maze
	 * 
	 * @return row
	 */
	public int getRows()
	{
		return row;
	}

	/**
	 * Returns the amount of columns in the maze
	 * 
	 * @return col
	 */
	public int getCols()
	{
		return col;
	}

	/**
	 * Returns the squares type
	 * 
	 * @return type
	 */
	public int getType()
	{
		return type;
	}

	/**
	 * Returns the status of the square in the workList
	 * 
	 * @return status
	 */
	public char getStatus()
	{
		return status;
	}

	/**
	 * This equals method determines if two squares are equal by its rows and cols,
	 * if they are the same, then return true
	 */
	@Override
	public boolean equals(Object obj)
	{
		Square temp = (Square) obj;
		if (this.row == temp.getRows() && this.col == temp.getCols())
		{
			return true;
		}
		return false;
	}

	/**
	 * Returns the value of the previous square
	 * 
	 * @return squarePrevious
	 */
	public Square getSquarePrevious()
	{
		return squarePrevious;
	}

	/**
	 * resets the type of the status of a square
	 */
	public void resetType()
	{
		status = ' ';
	}

	/**
	 * Sets the previous square equal to a square
	 * 
	 * @param sq
	 */
	public void setSquarePrevious(Square sq)
	{
		squarePrevious = sq;
	}

	/**
	 * Sets the type equal to the parameter num
	 * 
	 * @param num
	 */
	public void setType(int num)
	{
		type = num;
	}

	/**
	 * Sets the status equal to the parameter c
	 * 
	 * @param c
	 */
	public void setStatus(char c)
	{
		status = c;
	}

	/**
	 * isMarked() returns true if type == wall , or if the square was in the
	 * workList
	 */
	public boolean isMarked()
	{
		if (type == WALL || status == 'o' || status == '.')
		{
			return true;
		} else
			return false;
	}

	@Override
	public String toString()
	{
		switch (type)
		{
		case WALL:
			return "#";
		case EMPTY:
			switch (status)
			{
			case WORKING:
				return "o";
			case WORKED:
				return ".";
			case EXIT_PATH:
				return "x";
			default:
				return "_";
			}

		case START:
			return "S";
		case EXIT:
			return "E";
		}
		return "";

	}
}
