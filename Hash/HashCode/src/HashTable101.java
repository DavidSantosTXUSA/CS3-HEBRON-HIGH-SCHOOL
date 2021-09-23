
public class HashTable101
{
	public static void main(String args[])
	{
		Object[] hashTable = new Object[10];

		Character c = 'g';
		System.out.println("hashCode for \'c\': " + c.hashCode());
		hashTable[c.hashCode() % 10] = c;// 103 % 10 == 3

		Character d = 'A';
		hashTable[d.hashCode() % 10] = d; // 65 % 10 == 5

		Integer num = 118;
		hashTable[num.hashCode() % 10] = num; // 118 % 10 == 7

		String s = "e";
		hashTable[s.hashCode() % 10] = s; // 101 % 10 == 1
		
		System.out.println("\nHash Table:");
		
		int index = 0;
		
		for(Object thing : hashTable)
		{
			System.out.println("Index " + index++ + ": " + thing);
		}

		
	}
}
