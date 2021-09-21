import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class HistogramRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner key = new Scanner(new File("histogram.dat"));
		Histogram run = new Histogram();
		while(key.hasNextLine()) {
			run = new Histogram(key.nextLine());
			run.setSentence();
			System.out.println(run);
		}
	}
}