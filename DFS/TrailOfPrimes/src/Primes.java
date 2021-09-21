import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Primes
{
	/**
	 * NOTE THIS CODE IS OOGA BOOGA 0 - 4 steps: Instant. 5 steps - 5 min. 6 steps -
	 * 45 min. 7 steps - 2 hours
	 */
	private static Queue<Stack<Integer>> search;// different paths to be searched
	private static Queue<Stack<Integer>> paths;// final path
	private static Queue<Integer> qq;
	private static Integer end;// ending number
	private static Integer start;// starting number

	public static void main(String args[])
	{
		start = 1033;
		end = 1151;
		SieveOfEratos run = new SieveOfEratos();
		qq = run.getPrimes(end);
		System.out.println(solve());
		int output = paths.remove().size();
		System.out.println(output -= 1);
	}

	/**
	 * returns a queue of Integers that are 4 digit prime numbers that are one digit
	 * different than Integer num
	 * 
	 * @param num a 4 digit prime number
	 * @return queue of 4 digit prime numbers that are one digit different than num
	 */
	public static Queue<Integer> getDiffByOne(Integer num)
	{
		
		
		//String temp = num.toString();
		int size = qq.size();
		for (int i = 0; i < size; i++)
		{
			String temp2 = qq.poll().toString();
			if (temp2.length() == 4)// only re adds primes that are 4 digits long
			{
				qq.add(Integer.parseInt(temp2));
			}
		}
		size = qq.size();
		for (int i = 0; i < size; i++)
		{
			String temp3 = qq.poll().toString();
			if (bruh(temp3, num.toString()))// ensures only numbers one digit off will be added back
			{
				qq.add(Integer.parseInt(temp3));
			}
		}
		return qq;
	}

	public static void add(Stack<Integer> here)
	{
		Queue<Integer> diffOne = getDiffByOne(here.peek());
		for (Integer temp : diffOne)
		{
			Stack<Integer> copy = new Stack<Integer>();
			copy.addAll(here);
			copy.push(temp);
			search.add(copy);

		}
	}

	/**
	 * gets a solution by searching into the paths will always return the shortest
	 * path if it exists because the first path found will be the least amount of
	 * elements
	 * 
	 * @return paths A stack queue of the fastest path
	 */
	public static Queue<Stack<Integer>> solve()
	{
		int depth = Integer.MAX_VALUE;
		search = new LinkedList<Stack<Integer>>();
		;
		Integer second = end;

		Queue<Integer> diffOne = getDiffByOne(start);

		for (Integer temp : diffOne)
		{
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(start);
			//add first number
			stack.push(temp);
			//adds one number from the diffOne queue
			search.add(stack);
			//adds the stack to the queue

		}

		while (!search.isEmpty())
		{
			//dequeue
			Stack<Integer> here = search.remove();
			Integer last = here.peek();
			//if we solved we return stack
			if (last.equals(second))
			{
				if (here.size() < depth)
				{
					depth = here.size();// new smallest size
					paths = new LinkedList<Stack<Integer>>();
					paths.add(here);
				}
			} else
			{
				if (here.size() + 1 <= depth)// only add if this path is shorter
				{
					add(here);
				}
			}

		}
		return paths;

	}

	/**
	 * compares every digit of the two String nums passed use parse int to pass ints
	 * into string to use this method increments a count if the digit is the same ,
	 * if 3 or more are different then it must mean they are 1 digit different
	 * @param num
	 * @param num2
	 * @return true if the two numbers passed are one digit different
	 */
	public static boolean bruh(String num, String num2)
	{
		int count = 0;
		for (int i = 0; i < num.length(); i++)
		{
			if (num.charAt(i) == num2.charAt(i))
			{
				count++;
			}
			if (count >= 3)
			{
				return true;
			}
		}
		return false;
	}
}