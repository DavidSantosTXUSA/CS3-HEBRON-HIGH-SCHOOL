
public class Runner
{
	public static void main(String args[])
	{
		Maze m = new Maze();
		m.loadMaze("maze1.txt");
		System.out.println(m);
		m.solve();
		System.out.println();
		m = new Maze();
		m.loadMaze("maze2.txt");
		System.out.println(m);
		m.solve();
		m = new Maze();
		System.out.println();
		m.loadMaze("maze3.txt");
		System.out.println(m);
		m.solve();
	}
	
}
