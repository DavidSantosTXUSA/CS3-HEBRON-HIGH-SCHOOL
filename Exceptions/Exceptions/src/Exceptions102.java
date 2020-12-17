import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * All exceptions ultimately derive from the Throwable class.
 * The immediate subclasses of throwable are error and exception
 * Exceptions are the IOexception and RunTime Exception.
 * IOExceptions are used for exceptions beyond you control (like the disk is full)
 * RunTimeExceptions indicate programmer error( you tried to write past the end of a array)
 */

public class Exceptions102
{
	/*
	 * IOExceptions are considered "checked exceptions."
	 * "Checked" refer to the fact that the compiler will check to ensure
	 * that exception is caught. Checked exceptions that are
	 * not monitored by a try/catch block
	 * 
	 * You must mark your method to indicate that it throws this exception
	 */
	
	public static void readFile1() throws IOException
	{
		File file = new File("mystery.txt");
		Scanner scan = new Scanner(file);
	}
	
	public static void readFile2()
	{
		try
		{
			File file = new File("mystery.txt");
			Scanner scan = new Scanner(file);
		}
		catch(IOException e)
		{
			System.out.println("That be no file here matey!");
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		//readFile1();
		readFile2();
	}
}
