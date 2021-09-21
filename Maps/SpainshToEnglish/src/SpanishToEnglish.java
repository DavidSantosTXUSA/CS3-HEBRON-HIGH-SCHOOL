import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanishToEnglish
{
	private Map<String, String> pairs;

	/**
	 * default constructor
	 */
	public SpanishToEnglish()
	{

		pairs = new TreeMap<String, String>();

	}

	/**
	 * fills the map with each 
	 * english to spainsh pair
	 * @param entry
	 */
	public void putEntry(String entry)
	{
		String[] list = entry.split(" ");
		//System.out.println(entry); debugging
		pairs.put(list[0], list[1]);
		// translate(entry); debugging
	}

	/**
	 * translates String sent
	 * by using the map and returns
	 * the translated output
	 * @param sent
	 * @return output
	 */
	public String translate(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output = "";
		String[] list = sent.split(" ");
		for (int i = 0; i < list.length; i++)
		{
			output += pairs.get(list[i]);
			output += " ";
		}
		return output;
	}

	public String toString()
	{
		return pairs.toString().replaceAll("\\,", "\n");
	}
}