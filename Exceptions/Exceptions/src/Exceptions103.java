import java.util.Scanner;

/*
 * Unchecked exceptions, such as the Arithmetic Exception 
 * that is thrown when you divide by zero, are not required 
 * to be handled by your program.
 */

public class Exceptions103
{

	public static void main(String[] args)
	{
		DivideTester2 test = new DivideTester2();
		Scanner keyboard = new Scanner(System.in);
		String ans;

		do
		{
			
			test.getNumbers(); // get two numbers
			//We still get a default divide by exception here
			//test.divide(); // calculate the quotient
			//test.printResults(); // print the results
			//Now it is the responsibility of the calling method main to handle the exception.
			try
			{
				test.divide();
				test.printResults();
			}
			catch(ArithmeticException e)
			{
				System.out.println("You tried to divide by 0 bruh");
			}
			System.out.print("Continue[Y/N]?");
			ans = keyboard.nextLine();
			System.out.println();
		} while (ans.equalsIgnoreCase("y"));
	}
}

	class DivideTester2
	{
		private int dividend;
		private int divisor;
		private int quotient = 99;

		public void getNumbers()
		{
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter the Dividend-->");
			dividend = keyboard.nextInt();
			System.out.print("Enter the Divisor-->");
			divisor = keyboard.nextInt();
			System.out.println();
		}

		/*
		 * Marking a method with the throws keyword instructs the JVM
		 * ro pass any exceptions that occur within the method onto
		 * the calling method so they can be handled there.
		 */
		public void divide() throws ArithmeticException
		{
			quotient = dividend / divisor;

		}

		public void printResults()
		{
			System.out.println(dividend + " / " + divisor + " = " + quotient);
			System.out.println();
		}

	}

