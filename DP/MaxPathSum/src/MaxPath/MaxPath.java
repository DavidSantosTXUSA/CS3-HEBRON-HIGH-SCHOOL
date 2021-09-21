import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MaxPath
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner key = new Scanner(new File("triangle.txt"));
		int[][] table = new int[100][300];
		int count = 1;
		for (int i = 0; i < table.length; i++)
		{
			for (int j = 0; j < count; j++)
			{
				table[i][j] = key.nextInt();
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
			count++;
		}
		System.out.println();
		System.out.println("Max total : " + maxPathSum(table, table.length - 1, table[0].length - 1));
	}

	/**
	 * Returns the maximum total from the top of the triangle. Starts from the
	 * bottom of the triangle (DP)
	 * 
	 * @param triangle - the 2d array list representing the triangle
	 * @param rows     - rows of the triangle
	 * @param cols     - columns of the triangle
	 * @return
	 */
	static int maxPathSum(int triangle[][], int rows, int cols)
	{
		// start at bottom row
		for (int i = rows - 1; i >= 0; i--)
		{
			for (int j = 0; j < cols; j++)// loop through columns
			{
				// compares the two values above and adds to the max
				triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
			}
		}
		return triangle[0][0];
	}
}
