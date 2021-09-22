import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> implements StackADT
{
	/**
	 * Integer[] array stack that stores data like a stack
	 */
	private Square[] stack;

	/**
	 * int variable size that keeps track of the top index of the stack
	 */
	private int size;

	/**
	 * default constructor that sets size and stack to default values
	 */
	public MyStack()
	{
		size = -1;
		stack = new Square[1];
	}

	/**
	 * overloaded constructor that calls this() and sets stack to a size determined
	 * by user input
	 * 
	 * @Param int initCap size of the stack
	 */
	public MyStack(int initCap)
	{
		this();
		stack = new Square[initCap];
	}

	/**
	 * checks if the stack is Empty
	 * 
	 * @Return true if stack is empty
	 */
	public boolean isEmpty()
	{
		return stack.length == 0 || stack[0] == null;
	}

	/**
	 * Returns the top element without removing item throws a exception if stack is
	 * empty
	 * 
	 * @Return element at the top of the stack
	 */
	public Square peek()
	{
		if (isEmpty())
		{
			throw new EmptyStackException();
		} else
		{
			Square temp = stack[size];
			return temp;
		}

	}

	/**
	 * removes the top element and also returns the top element before removing it
	 * throws a EmptyStackException
	 * 
	 * @Return the top element of the stack
	 */
	public Square pop()
	{
		if (isEmpty())
		{
			throw new EmptyStackException();
		} else
		{
			Square num = stack[size];
			stack[size] = null;
			size--;
			return num;
		}

	}

	/**
	 * Adds a item to the top of the stack calls the doubleCapacity() method if more
	 * space is needed
	 * 
	 * @Param Integer item
	 */
	public void push(Square item)
	{
		if (stack.length == 0 || stack[stack.length - 1] != null || size == -1 || stack.length <= size)
		{
			doubleCapacity();
		}

		size++;
		stack[size] = item;

	}

	/**
	 * Doubles the phyiscal size of the stack
	 */
	private void doubleCapacity()
	{
		Square[] clone = new Square[((stack.length + 1) * 2)];
		for (int i = 0; i < size; i++)
		{
			clone[i] = stack[i];
		}
		stack = clone;

	}

	public int size()
	{
		return size;
	}

	public void clear()
	{
		while (!isEmpty())
		{
			pop();
		}
	}

	@Override
	public String toString()
	{
		/*
		 * old method kept it just in case it would be needed later String output =
		 * "[ "; for(int i = 0; i <= stack.length-1; i++) { output+=stack[i];
		 * if(i!=stack.length-2) { output+=", "; }
		 * 
		 * } output+=" ]"; return output;
		 */
		return Arrays.toString(stack);
	}
}
