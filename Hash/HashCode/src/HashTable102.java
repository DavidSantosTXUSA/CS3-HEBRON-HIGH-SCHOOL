import java.util.LinkedList;

public class HashTable102
{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args)
	{
		LinkedList[] hashTable = new LinkedList[10];

		for (LinkedList list : hashTable)
		{
			System.out.println(list);
		}

		System.out.println("\n");

		for (int i = 0; i < hashTable.length; i++)
		{
			hashTable[i] = new LinkedList();
		}

		System.out.println("\n");

		Character c = 'g';
		hashTable[c.hashCode() % 10].add(c);

		c = 'd';
		hashTable[c.hashCode() % 10].add(c);

		c = 'c';
		hashTable[c.hashCode() % 10].add(c);

		c = 'B';
		hashTable[c.hashCode() % 10].add(c);

		Integer num = 45;
		hashTable[num.hashCode() % 10].add(num); 

		num = 113;
		hashTable[num.hashCode() % 10].add(num);
		
		num = 263;
		hashTable[num.hashCode() % 10].add(num);
		
		num = 303;
		hashTable[num.hashCode() % 10].add(num);
		
		String s = "rgb";
		hashTable[s.hashCode() % 10].add(s);

		int index = 0;
		
		for (LinkedList list : hashTable)
		{
			System.out.print("Index " + index++ + ": ");
			for(Object thing : list)
			{
				System.out.print(thing + " -> ");
			}
			System.out.println();
		}
		
	}

}
