import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class AcroRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner key = new Scanner(new File("acro.dat"));
		int num = key.nextInt();
		key.nextLine();
		Acronyms run = new Acronyms();
		for(int i = 0; i < num; i++)
		{
			run.putEntry(key.nextLine());
		}
		while(key.hasNextLine())
		{
			run.convert(key.nextLine());
		}
		System.out.println(run);
	}
}