import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MinCoins
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner key = new Scanner(new File("coins.dat"));
		int num = key.nextInt();
		key.nextLine();
		for (int i = 0; i < num; i++)
		{
			int sum = key.nextInt();

			key.nextLine();
			String[] array = key.nextLine().split(" ");
			Integer[] coins = new Integer[array.length];
			System.out.print("Given denominations: ");
			for (int j = 0; j < coins.length; j++)
			{
				coins[j] = Integer.parseInt(array[j]);
				System.out.print(coins[j] + " ");
			}
			System.out.println();
			System.out.println("Sum to reach : " + sum);
			int min = minCoins(coins, coins.length, sum);
			if (min == Integer.MAX_VALUE)// if Integer.MAX_VALUE is returned it means the table was never changed
											// therefore not possible
			{
				System.out.println("Not possible with the given denominations");
			} else
			{
				System.out.println("at least " + min + " coins needed");
			}
			System.out.println();
		}
	}

	/**
	 * Finds the minimum amount of coins needed for change 
	 * for a given sum. uses dynamic programming to reach the result fast
	 * @param coins - array of the denominations of the cons
	 * @param length - length of the coins array
	 * @param sum - sum to reach for given the coins
	 * @return the minimum amount of coins needed
	 */
	public static int minCoins(Integer[] coins, int length, int sum)
	{

		// if sum is 0 then there is not a way to give change so return 0
		if (sum == 0)
		{
			return 0;
		}
		int[] min = new int[sum + 1];
		min[0] = 0;
		for (int i = 1; i < min.length; i++)
		{
			min[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= sum; i++)
		{
			for (int j = 0; j < length; j++)
			{
				// min[i - coins[j]] != Integer.MAX_VALUE prevents Integer overflow
				if (coins[j] <= i && min[i - coins[j]] != Integer.MAX_VALUE && min[i - coins[j]] + 1 < min[i])
				{
					min[i] = min[i - coins[j]] + 1;
				}

			}
		}
		return min[sum];
	}
}
