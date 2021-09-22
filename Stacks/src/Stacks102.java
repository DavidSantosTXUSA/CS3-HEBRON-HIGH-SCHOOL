import java.util.Stack;
import java.awt.Color;
public class Stacks102
{
	public static void main(String args[])
	{
		//Java 5+ prefers, doesnt require that you specify
		Stack<String> myStack = new Stack<String>();
		//myStack.push(Color.RED);//ERROR
		myStack.push("Michael");
		myStack.push("Raymond");
		myStack.push("David");
		myStack.push("Jackson");
		myStack.push("Gabby");
		
		System.out.println("\nPrinting stack with loop:");
		for(int i = 0; i < myStack.size(); i++)
		{
			System.out.println(i + ". " + myStack.get(i));
		}
		System.out.println();
		
		System.out.println(myStack); 
		
		System.out.println("-*Popping 1 element from top of stack*-\n");
		myStack.pop();
		System.out.println("\nPrinting stack with loop:");
		for(int i = 0; i < myStack.size(); i++)
		{
			System.out.println(i + ". " + myStack.get(i));
		}
		System.out.println();
		
		System.out.println("Popping " + myStack.pop() + " from top of stack");
		System.out.println("Popping " + myStack.pop() + " from top of stack");
		System.out.println("\nPrinting stack with loop:");
		for(int i = 0; i < myStack.size(); i++)
		{
			System.out.println(i + ". " + myStack.get(i));
		}
	}
}
