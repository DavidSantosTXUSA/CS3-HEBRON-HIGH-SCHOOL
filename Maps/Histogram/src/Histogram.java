import java.util.Map;
import java.util.TreeMap;

public class Histogram
{
	private Map<String,Integer> histogram;
	private String sent;

	/**
	 * Default constructor
	 */
	public Histogram()
	{
		histogram = new TreeMap<String, Integer>();
		sent = "";
	}

	/**
	 * overloaded constructor 
	 * takes in a String that we
	 * use to set the sentence and
	 * use later to count the characters
	 * @param sent
	 */
	public Histogram(String sent)
	{
		histogram = new TreeMap<String, Integer>();
		this.sent = sent;
		setSentence();
	}
	
	/**
	 * where the magic is done
	 * Adds every character to the map
	 * if it isnt in it already
	 * if it is in it then we 
	 * take the current number 
	 * that is paired with it and 
	 * increment it by one else we just
	 * add it to the map with a value of 1
	 */
	public void setSentence()
	{
		String[] line = sent.split(" ");
		histogram = new TreeMap<String, Integer>();
		for(String c: line)
		{
			int counter = 0;
			if(histogram.containsKey(c))
			{
				counter = histogram.get(c);
			}
			histogram.put(c,counter+1);
			
		}
	}
	

	/**
	 * toString() method
	 */
	public String toString()
	{
		String output="char\t1---5----10\n";
		for(String c: histogram.keySet())
		{
			int count = histogram.get(c);
			output+= c + "\t";
			for(int i = 0; i < count; i++)
			{
				output+="*";
			}
			output+="\n\n";
		}
		return output+"\n\n";
	}
}