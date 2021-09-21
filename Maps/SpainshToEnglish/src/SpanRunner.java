import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanRunner
{
	public static void main(String args[]) throws IOException
	{
		Scanner key = new Scanner(new File("spantoeng.dat"));
		SpanishToEnglish run = new SpanishToEnglish();
		int inputs = key.nextInt();
		key.nextLine();
		for (int i = 0; i < inputs; i++)
		{
			String temp = key.nextLine();
			run.putEntry(temp);
		}
		System.out.println(run);
		System.out.println();
		while (key.hasNextLine())
		{
			System.out.println(run.translate(key.nextLine()));
		}

	}
}