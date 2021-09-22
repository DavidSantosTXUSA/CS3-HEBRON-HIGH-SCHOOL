import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class IteratorRemover
{
	private ArrayList<String> list;
	private String toRemove;
	private Iterator<String> Iterator;
	//Constructor that sets list using the split method
	//calls the setTest method
	//@Param the list of words and the word to be removed
	public IteratorRemover(String line, String rem)
	{
		String[] words = line.split(" ");
		list = new ArrayList<String>(Arrays.asList(words));
		Iterator = list.iterator();
		setTest(line,rem);
	}

	//checks to see which item in the list needs to be removed
	//@Param the string of words, the word to be removed
	public void setTest(String line, String rem)
	{
		int counter = 0;
		while(Iterator.hasNext())//goes through the array using the iterator
		{
			String str = (String) Iterator.next();
			if(str.equals(rem))
			{
				remove();
			}
			counter++;
		}
		
		
	}

	public void remove()
	{
		Iterator.remove();
	}

	public String toString()
	{
		return  list.toString();
	}
}