import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorRemoverRunner
{
	public static void main ( String[] args )
	{
		//add test cases	
		IteratorRemover test = new IteratorRemover("a b c a b c a","a");
		System.out.println(test);
		IteratorRemover test2 = new IteratorRemover("a b c d e f g h i j x x x x","x");
		System.out.println(test2);
		IteratorRemover test3 = new IteratorRemover("1 2 3 4 5 6 a b c a b c","b");
		System.out.println(test3);
	}
}