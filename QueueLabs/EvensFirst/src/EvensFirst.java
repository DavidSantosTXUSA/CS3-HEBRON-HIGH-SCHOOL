import java.util.LinkedList;
import java.util.Queue;

public class EvensFirst
{
	private Queue<Integer> queue;
	private String[] nums;// used to convert a String into a queue

	/**
	 * Default constructor sets queue to its default value
	 * 
	 */
	public EvensFirst()
	{
		queue = new LinkedList<Integer>();
	}

	/**
	 * Overloaded constructor fills queue with String line
	 * 
	 * @param line
	 */
	public EvensFirst(String line)
	{
		queue = new LinkedList<Integer>();
		nums = line.split(" ");
		for (int i = 0; i <= nums.length - 1; i++)
		{
			queue.add(Integer.parseInt(nums[i]));
		}
	}

	/**
	 * Takes in Q and puts all evens in front of the queue and all odds in the back
	 * 
	 * @param Q
	 * @return queue with evens first
	 */
	public Queue<Integer> putEvensFirst(Queue<Integer> Q)
	{
		Queue<Integer> queue2 = new LinkedList<Integer>();
		Queue<Integer> queue3 = Q;
		Queue<Integer> queue4 = new LinkedList<Integer>();
		for (int i = 0; i <= nums.length - 1; i++)
		{
			if (queue3.peek() % 2 != 0)
			{
				queue2.add(queue3.poll());
			} else
			{
				queue4.add(queue3.poll());
			}

		}

		while(queue2.isEmpty()==false) 
		{
			
			queue4.add(queue2.poll());
		}
		return queue4;

	}

	@Override
	public String toString()
	{
		return putEvensFirst(queue) + "";
	}
}
