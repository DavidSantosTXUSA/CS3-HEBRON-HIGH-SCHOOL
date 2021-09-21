import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountPaths
{
	private static long[][] memo;
	private static int rows;
	private static int cols;

	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner key = new Scanner(new File("paths.dat"));
		int num = key.nextInt();
		key.nextLine();
		for (int i = 0; i < num; i++)
		{
			rows = key.nextInt();
			cols = key.nextInt();
			if(rows==0||cols==0)
			{
				System.out.println(1);//was not sure if a maze with a 0 row or col is supposed to be 1 or 0
			}else
			{
				numPaths(new long[rows][cols]);
				System.out.println( memo[rows - 1][cols - 1]);
			}
		}

	}
	/**
	 * A caller method to a DP helper 
	 * call this method with a matrix and it will 
	 * call the helper to give the number of possible 
	 * routes in the matrix
	 * @param memo2 - the matrix passed
	 */
	public static void numPaths(long[][] memo2)
	{
		helper(0, 0, memo2);
		memo = memo2;
	}

	/*
	 * uses memo2 to remember outputs and save time on calcuation
	 * helps return the number of all possible routes
	 */
	private static void helper(int row, int col, long[][] memo2)
	{
		if (row == 0 || col == 0)
		{
			memo2[row][col] = 1;
		} else
		{
			memo2[row][col] = memo2[row - 1][col] + memo2[row][col - 1] + memo2[row - 1][col - 1];
		}
		if (row + 1 >= 0 && row + 1 < rows)//if row is in bounds
		{
			helper(row + 1, col, memo2);
		}
		if (col + 1 >= 0 && col + 1 < cols)//if col is in bounds
		{
			helper(row, col + 1, memo2);
		}
		if (row + 1 >= 0 && row + 1 < rows && col + 1 >= 0 && col + 1 < cols)// if bound in bounds
		{
			helper(row + 1, col + 1, memo2);
		}
	}

}