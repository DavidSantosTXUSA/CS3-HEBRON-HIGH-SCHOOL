import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Scanner;
import static java.lang.System.*;

public class Relatives
{
	private Map<String, Set<String>> map;

	/**
	 * default constructor
	 */
	public Relatives()
	{
		map = new TreeMap<String, Set<String>>();
	}

	/**
	 * sets all the people to their respective relatives into a map
	 * 
	 * @param line
	 */
	public void setPersonRelative(String line)
	{
		String[] personRelative = line.split(" ");
		Set<String> relatives = new TreeSet<String>();
		if (map.containsKey(personRelative[0]))//allows people to have more than one relative
		{
			relatives = map.get(personRelative[0]);
		}
		relatives.add(personRelative[1]);
		map.put(personRelative[0], relatives);
	}

	/*
	 * toString method()
	 */
	public String toString()
	{
		String output = "";
		for (String person : map.keySet())
		{
			output += person + " is related to ";
			Set<String> relatives = map.get(person);
			int count = 0;
			for (String name : relatives)
			{
				if (count < relatives.size()-1)
				{
					output += name + ", ";
				} else
				{
					output += name;
				}
				count++;
			}
			output += "\n";
		}
		return output;
	}
}