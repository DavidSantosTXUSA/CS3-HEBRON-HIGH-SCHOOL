public class MazeSolverStack extends MazeSolver
{

	private MyStack<Square> workList;

	/**
	 * Constructor that takes in the parameter maze and calls the super() method and
	 * adds the start to the workList
	 * 
	 * @param maze
	 */
	public MazeSolverStack(Maze maze)
	{
		super(maze);
		workList = new MyStack<Square>();
		add(maze.getStart());
	}

	/**
	 * makes workList a empty MyStack
	 */
	@Override
	public void makeEmpty()
	{
		workList = new MyStack<Square>();
	}

	/**
	 * calls the isEmpty() method from my stack which returns true if the stack is
	 * empty
	 */
	@Override
	public boolean isEmpty()
	{
		return workList.isEmpty();
	}

	/**
	 * calls the push() method from myStack to add a square
	 * 
	 * @Param Square s
	 */
	@Override
	public void add(Square s)
	{
		workList.push(s);
	}

	/**
	 * in order to get the next item in the worklist, we pop() the top item in order
	 * to "explore" it and work the next item in the workList
	 */
	@Override
	public Square next()
	{
		return workList.pop();
	}
}
