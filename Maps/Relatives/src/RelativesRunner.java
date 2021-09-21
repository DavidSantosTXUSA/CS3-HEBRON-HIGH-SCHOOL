import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class RelativesRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner key = new Scanner(new File("relatives.dat"));
		int num = key.nextInt();
		key.nextLine();
		Relatives run = new Relatives();
		for(int i = 0; i < num; i++)
		{
			run.setPersonRelative(key.nextLine());
		}
		System.out.println(run);
	}
}