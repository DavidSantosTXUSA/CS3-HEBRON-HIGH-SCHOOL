import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Scooby
{
	/**
	 * 5 is just a random number could have made a separate class and just added a
	 * normal constructor that sets it to null or 0
	 */
	private static LinkedList<String> adj[] = new LinkedList[5];

	private static String output = "no";// the String that we will output at the end could change to yes

	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner key = new Scanner(new File("scooby.dat"));
		int num = key.nextInt();
		key.nextLine();
		
		LinkedList<String> adj[];
		for (int i = 0; i < num; i++)
		{
			String line = key.nextLine();
			String[] array = line.split(" ");
			String path = key.nextLine();

			adj = new LinkedList[array.length];
			for (int j = 0; j < array.length; j++)
			{
				adj[j] = new LinkedList();
				adj[j].add(array[j]);

			}
			for (int k = 0; k < adj.length; k++)
			{
				System.out.print(adj[k] + " ");
			}
			System.out.println("\n" + path);

			hasConnection_DFS(adj, path.substring(0, 1), path.substring(1), 0);
			System.out.println(output);
		}
	}

	/**
	 * Works by finding if the room we are looking for is in the current room, if not 
	 * go to another index, once we find the room we are looking for then we find another connection
	 * this repeats until we made the connection we are looking for, default value for output is "no"
	 * just in case the rooms we are looking for dont exist
	 * @param adj2 adjacency matrix for the rooms
	 * @param room the room we are in
	 * @param find room we are looking for
	 * @param i index
	 */
	public static void hasConnection_DFS(LinkedList<String> adj2[], String room, String find, int i)
	{

		if (i == adj2.length)//we checked everything and still didnt get a "yes" and return so it must be "no"
		{
			output = "no";
			return;
		}
		if (adj2[i].toString().contains(find))//there is a path so its possible there is a solution
		{
			output = "yes";
			return;
		} else
		{
			for (int k = 0; k < adj2.length; k++)
			{
				if (adj2[k].toString().contains(room))
				{
					hasConnection_DFS(adj2, adj2[k].toString().substring(2, 3), find, ++i);
				}
			}

		}
		return;
	}


}

