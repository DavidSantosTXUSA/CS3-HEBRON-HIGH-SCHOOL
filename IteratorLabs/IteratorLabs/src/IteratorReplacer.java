import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorReplacer
{
	private ArrayList<Integer> list;
	private int toRemove, replaceWith;
	private ListIterator<Integer> iter;
	public IteratorReplacer(String line, String rem, String rep)
	{
		toRemove = Integer.parseInt(rem);
		replaceWith = Integer.parseInt(rep);
		String[] nums = line.split(" ");
		Integer[] nums2 = new Integer[nums.length];
		for(int i = 0; i < nums.length;i++)
		{
			nums2[i]=Integer.parseInt(nums[i]);
		}
		list = new ArrayList<Integer>(Arrays.asList(nums2));
		iter = list.listIterator();
		setEmAll(line,rem,rep);
	}

	public void setEmAll(String line, String rem, String rep)
	{
		while(iter.hasNext())
		{
			int num = (int) iter.next();
			if(num==toRemove)
			{
				replace();
			}
		}
	}	

	
	public void replace()
	{
		iter.remove();
		iter.add(replaceWith);
	}

	public String toString()
	{
		return list.toString()+"\n\n";
	}
}