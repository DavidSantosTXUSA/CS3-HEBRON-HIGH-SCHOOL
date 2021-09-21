import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RodCutting
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner key = new Scanner(new File("rod.dat"));
		int tests = key.nextInt();
		for (int i = 0; i < tests; i++)
		{
			int length = key.nextInt();
			key.nextLine();
			Integer[] prices = new Integer[length];
			String moneys = key.nextLine();
			String[] array = moneys.split(" ");
			for (int j = 0; j < length; j++)
			{
				prices[j] = Integer.parseInt(array[j + 1]);// ensures we skip the 0 since a rod of 0 length will always
															// be worthless
				// now index 0 = length 1, index 1 = length 2 and so on
				System.out.print("length " + (j + 1) + " is worth " + prices[j] + " ... ");
			}
			System.out.println();
			System.out.println("Max value for rod of length " + length + " -> " + cutRod(length, prices));
		}
	}

	/**
	 * Finds the max profit of cutting a rod given its value at every length and the
	 * length of the rod
	 * 
	 * @param length - length of the rod;
	 * @param price  - prices for each length
	 * @return the max profit of cutting a rod
	 */
	public static int cutRod(int length, Integer price[])
	{
		int values[] = new int[length + 1];
		values[0] = 0;
		for (int i = 1; i <= length; i++)
		{
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++)
			{
				max = Math.max(max, price[j] + values[i - j - 1]);
			}
			values[i] = max;
		}
		return values[length];
	}
}
