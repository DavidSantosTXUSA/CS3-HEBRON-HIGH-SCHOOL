import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class IteratorReplacerRunner
{
	public static void main ( String[] args )
	{
		IteratorReplacer test = new IteratorReplacer("1 2 3 1 2 4","1","5");
		System.out.println(test);
		IteratorReplacer test2 = new IteratorReplacer("1 2 3 4 5 6 7 8 9 10 -1 -1 -1" ,"-1" ,"42");
		System.out.println(test2);
		IteratorReplacer test3 = new IteratorReplacer("3 1 4 1 5 9 3 3 72 -3 2 3 6","3","0");
		System.out.println(test3);
	}
}