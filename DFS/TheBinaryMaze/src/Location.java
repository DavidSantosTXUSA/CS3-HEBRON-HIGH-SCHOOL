
public class Location
{
	
	public final static int EMPTY = 0;//While I never use these final variables 
	public final static int WALL = 1;//They show a viewer seeing this code what 0 and 1 mean for the maze
	private boolean isStart;//true or false if the location is the start
	private boolean isExit;//true or false if the location is the end
	private boolean isVisited;//true or false if the location has been visited
	private int row, col, type;//row , column values and type of location (wall or empty)
	private Location previousLocation;// a reference to the previous location (never got around to using it)

	/**
	 * Constructor that takes in the 
	 * row and column value for the location to 
	 * go into as well as the type (wall or empty)
	 * sets everything to default values
	 * @param row
	 * @param col
	 * @param type
	 */
	public Location(int row, int col, int type)
	{
		this.row = row;
		this.col = col;
		this.type = type;
		isVisited = false;
		isStart = false;
		isExit = false;
		previousLocation = null;
	}

	/**
	 * returns the row the location is at
	 * @return rows
	 */
	public int getRows()
	{
		return row;
	}

	/**
	 * returns the column the location is at
	 * @return column
	 */
	public int getCols()
	{
		return col;
	}

	/**
	 * returns the locations type
	 * 0 = wall , 1 == empty 
	 * @return type
	 */
	public int getType()
	{
		return type;
	}

	/**
	 * debugger method, prints out both
	 * the row and the col as a string 
	 * for debugging purposes
	 * @return row + " " + column
	 */
	public String getCoordinates()
	{
		return row + " " + col;
	}

	/**
	 * returns true if the location has been visited
	 * @return true if visited
	 */
	public boolean isVisited()
	{
		return isVisited;
	}
	
	/**
	 * setter method
	 * sets the isVisited boolean for the location
	 * @param boolean b
	 */
	public void setIsVisited(boolean b)
	{
		isVisited = b;
	}
	
	/**
	 * returns the reference to the previous location
	 * @return previousLocation
	 */
	public Location getPrevious()
	{
		return previousLocation;
	}

	/**
	 * returns true if this location is the start
	 * @return true if location is start
	 */
	public boolean isStart()
	{
		return isStart;
	}

	/**
	 * returns true if this location is the exit
	 * @return true if exit
	 */
	public boolean isExit()
	{
		return isExit;
	}

	/**
	 * setter method 
	 * sets if the location is a start
	 * @param boolean b
	 */
	public void setIsStart(boolean b)
	{
		isStart = b;
	}

	/**
	 * setter method
	 * sets if the location is a exit
	 * @param boolean b
	 */
	public void setIsExit(boolean b)
	{
		isExit = b;
	}

	/**
	 * sets the reference to the previous location
	 * @param Location l
	 */
	public void setPreviousLocation(Location l)
	{
		previousLocation = l;
	}

	/**
	 * overridden equals method
	 * a Location object is considered equal if BOTH
	 * the rows and columns are the same
	 */
	@Override
	public boolean equals(Object obj)
	{
		Location temp = (Location) obj;
		if (getRows() == temp.getRows() && col == temp.getCols())
		{
			return true;
		} else
		{
			return false;
		}
	}

	/**
	 * Overridden toString()
	 * prints out a 0 if a wall
	 * prints out 1 if a empty space
	 */
	@Override
	public String toString()
	{
		if (type == 0)
		{
			return "0";
		} else
		{
			return "1";
		}
	}
}
