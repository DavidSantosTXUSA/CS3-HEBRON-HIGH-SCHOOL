import java.util.Scanner;
import java.util.*;
public class IntegerCalculator
{
	static int d = 0;//basically just a true false thingy i made
	public static void main(String args[])
	{
		IntegerCalculator run = new IntegerCalculator();
		
		do//do while loop that keeps calling getInfo until the user quits
		{
			System.out.print("1)Add 2)Subtract 3)Multiply 4)Divide 5)Quit -->");
			run.getInfo();
		}while(d!=5);
		
	}
	
	public void getInfo()
	{
		int c = 0;
		int b = 0;
		int a = 0;
			Scanner key = new Scanner(System.in);
			try//The try/catch block we will use to catch a input that isnt a int
			{
				c = key.nextInt();
				System.out.print("\n");
			}
			catch(InputMismatchException e)
			{
				
				System.out.println("Not a valid number, try again.\n");
				return;//resets everything, used when a error happens so the user has to re input choice
			}
			
			
				if(c == 5)//if c = 5 it means we need to quit so we change d to 5 to make it not run again in the main method
				{
					d=5;
					return;
				}
				System.out.print("Operator 1 -->");
				try
				{
					a = key.nextInt();
				}
				catch(InputMismatchException e)
				{
					
					System.out.println("Not a valid number, try again.\n");
					return;
				}
				
				System.out.print("Operator 2 -->");
				try
				{
					b = key.nextInt();
				}
				catch(InputMismatchException e)
				{
					
					System.out.println("Not a valid number, try again.\n");
					return;
				}
				//if c = 1 do addition, c = 2 do subtraction, c = 3 do multiplication, c = 4 divide
			if(c == 1)
			{
				System.out.println("\n" + a + " + " + b + " = " + add(a,b));
			}
			if(c == 2)
			{
				System.out.println("\n" + a + " - " + b + " = " + subtract(a,b));
			}
			if(c == 3)
			{
				System.out.println("\n" + a + " * " + b + " = " + multiply(a,b));
			}
			if(c == 4)
			{
				divide(a,b);
			}
			
		}
	
	//adds the parameters a and b
	//@Param a and b the two ints to add
	//@return a+b
	public int add(int a, int b)
	{
		return a+b;
	}
	//subtracts the parameters a and b
	//@Param a and b the two ints to subtract
	//@Return a-b
	public int subtract(int a, int b)
	{
		return a-b;
	}
	//multiplies the parameters a and b
	//@Param a and b the two ints to multiply
	//@Return a*b
	public int multiply(int a, int b)
	{
		return a*b;
	}
	//divides the parameters a and b, also catches error if divides by zero
	//@Param a and b the two ints to divides
	//@Return a/b 
	public void divide(int a, int b)
	{
		int total = 0;
		
		try
		{
			total = a/b;
			System.out.println("\n" + a + " / " + b + " = " + total);
		}
		catch(ArithmeticException e)//catches if we divide by zero
		{
			System.out.println("Error: You cannot divide by zero!");
			return;
		}
	}
}
