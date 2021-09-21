import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ChildPlay
{
	
	private static int output;
	static LinkedList<String> adj[] = new LinkedList[5];
	/**
	* 5 is just a random number
	* could have made a separate class and just added 
	* a normal constructor that sets it to null or 0 
	*/
	public static void main(String args[]) throws FileNotFoundException
	{
		output = 0;
		Scanner key = new Scanner(new File("play2.dat"));
		int num = key.nextInt();//amount of test cases
		key.nextLine();
		LinkedList<String> adj[];
		for (int i = 0; i < num; i++)
		{
			String line = "";
			int n = key.nextInt();// number of tiles
			String[] tiles = new String[n];
			for (int j = 0; j < n; j++)
			{
				line = key.nextLine();
				line = line.replaceAll(" ", "");
				tiles[j] = line;//get the lines into a String[] array

			}
			adj = new LinkedList[tiles.length];
			for(int j = 0; j < tiles.length; j++)
			{
				adj[j] = new LinkedList();
				adj[j].add(tiles[j]);//graph that array
			}
			for (int k = 0; k < adj.length; k++)
			{
				//System.out.print(adj[k] + " ");//used for debugging 
			}
			for (int k = 0; k < adj.length; k++)
			{
			//	System.out.print(tiles[k] + " ");//used for debugging
			}
			String z = key.nextLine();//starting domino to knock over
			ChildPlay run = new ChildPlay();
			run.fallOver(adj, z, 0);
			System.out.println(output);
		}
	}
	
	/**
	 * 
	 * @param adj2 adjacency matrix of the domino's
	 * @param dom the domino we are looking to knock down
	 * @param index 
	 */
	public void fallOver(LinkedList<String>adj2[], String dom, int index)
	{
		if (adj2[index].toString().substring(2,3).equals(dom))//found piece to be knocked over
		{
			for (int i = 0; i < adj2.length; i++)//loop through 
			{
				//System.out.println(adj2[i].toString().substring(1, 2));debugging
				if (adj2[i].toString().substring(1, 2).equals(dom))//found which piece dom knocks over
				{
					output++;//increase output
					fallOver(adj2, adj2[i].toString().substring(2,3), index+1);//Recursive call to next index
				}
			}
		} else if (index + 1 != adj2.length)//if another recursive call wont go over bounds then we do another call of this method,ensures we go through every domino
		{
			fallOver(adj2, dom, index + 1);
		}

}
}
	 

