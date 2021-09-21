import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class Acronyms
{
	private Map<String, String> acronymTable;
	private String sent;

	/**
	 * Default constructor 
	 */
	public Acronyms()
	{
		acronymTable = new TreeMap<String, String>();
		sent = "";
	}

	/**
	 * puts all the entry's into the map
	 * @param entry
	 */
	public void putEntry(String entry)
	{
		String[] parts = entry.split(" - ");
		acronymTable.put(parts[0], parts[1]);
	}

	/**
	 * whenever we find a key in our map
	 * we add it to the output and ignore 
	 * Punctuation 
	 * @param sent
	 * @return output
	 */
	public String convert(String sent)
	{
		this.sent += sent+"\n";
		Scanner chop = new Scanner(sent);
		String output = "";
		int counter = 0;

		while (chop.hasNext())
		{
			String temp = chop.next();
			
			if (acronymTable.containsKey(temp.replaceAll("[.,?!\\\\n]", "")))//if has key
			{
				output += acronymTable.get(temp.replaceAll("[.,?!\\\\n]", ""));//add the translation
				
			} else
			{
				output += temp;//add normal word
			}
			counter++;
			output += " ";
			if (counter == 10)//every 10 words we go down to the next line to make it readable
			{
				output += "\n";
				counter = 0;
			}

		}

		return output;
	}

	/**
	 * toString
	 */
	public String toString()
	{
		String output = "==== MAP CONTENTS ====\n\n";
		output += acronymTable.toString();
		output = output.replaceAll(", ", "\n");
		output += "\n\n==== READ LINES ====\n\n";
		output += convert(sent);
		return output;
	}
}