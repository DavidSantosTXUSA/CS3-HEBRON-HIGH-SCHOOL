import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class PartList
{
	private TreeMap<Part, Integer> partsMap;

	public PartList()
	{
		partsMap = new TreeMap<Part, Integer>();
	}

	public PartList(String fileName)
	{
		this();
		try
		{
			// add code here to read from the file
			// and add Parts to the map
			
			Scanner key = new Scanner(new File(fileName));
			partsMap = new TreeMap<Part, Integer>();
			ArrayList<Part> parts = new ArrayList<Part>();
			while (key.hasNextLine())
			{
				parts.add(new Part(key.nextLine()));
			}
			int num = 0;
			for (int i = 0; i < parts.size(); i++)
			{
				num = 0;
				if (partsMap.containsKey(parts.get(i)))
				{
					num = partsMap.get(parts.get(i));
				}
				num++;
				partsMap.put(parts.get(i), num);
			}

		} catch (IOException e) // Most specific exceptions must be listed 1st
		{
			System.out.println(e );
		} catch (RuntimeException e)
		{
			System.out.println(e);
		} catch (Exception e)
		{
			System.out.println(e);
		} finally
		{
			// no code needed here
		}
	}

	public String toString()
	{
		String output = "";
		for(Part p : partsMap.keySet()) 
		{
			output+=p.toString() + " - " + partsMap.get(p) + "\n";
		}
		return output;
	}
}