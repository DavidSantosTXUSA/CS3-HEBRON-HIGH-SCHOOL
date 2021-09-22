import java.awt.Color;
import java.util.Stack;

public class Stacks101
{
	public static void main(String args[])
	{
		//old way (still works , might get warning message)
		
		Stack myStack = new Stack();
		
		//push()
		System.out.println("-*Pushing*-");
		
		System.out.println("Color.RED");
		myStack.push(Color.RED);
		
		System.out.println("abcde");
		myStack.push("abcde");
		
		System.out.println("409");
		myStack.push(409); //auto boxing
		
		System.out.println("\nPrinting stack with toString: ");
		System.out.println(myStack + "\n");
		
		//pop() removes an item from the stack 
		System.out.println("-*Popping*-");
		Integer x = (Integer) myStack.pop();
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		
	}
}
