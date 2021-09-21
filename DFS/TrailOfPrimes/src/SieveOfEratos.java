import java.util.LinkedList;
import java.util.Queue;

public class SieveOfEratos
{
	private Queue<Integer> primes;
	private int number;

	/**
	 * Default constructor that sets the queue primes and max number to default
	 * values
	 */
	public SieveOfEratos()
	{
		primes = new LinkedList<Integer>();
		number = 0;
	}

	/**
	 * Overloaded constructor that takes in int n and sets number equal to that
	 * 
	 * @param n
	 */
	public SieveOfEratos(int n)
	{
		primes = new LinkedList<Integer>();
		number = n;
	}

	/**
	 * Uses the sieve of eratos to get all the prime numbers less than int n
	 * 
	 * @param n
	 * @return prime numbers up to n
	 */
	public Queue<Integer> getPrimes(int n)
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		if (n < 2)
		{
			throw new IllegalArgumentException("No prime lower than 2 exists");
		}

		for (int i = 2; i <= n; i++)
		{
			queue.add(i);// fills queue with all numbers 2 to N
		}
		Integer num;
		do
		{
			num = queue.poll();
			primes.add(num);
			int size = queue.size();
			for (int i = 0; i < size; i++)
			{
				int temp = queue.poll();
				if (temp % num != 0)
				{
					queue.add(temp);
				}
			}
		} while (!queue.isEmpty());
		return primes;
	}

	@Override
	public String toString()
	{
		return getPrimes(number) + "";
	}
}
