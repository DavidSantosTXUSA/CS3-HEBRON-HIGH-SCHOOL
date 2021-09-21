import java.util.*;
import java.io.*;
import java.io.File; 
import java.util.Scanner; 
public class WordChain
{
	private String startWord;
	private String endWord;
	private Queue<String> ladder;
	private Stack<String> words;
	private ArrayList<String> dictionary;
	public WordChain() throws Exception
	{
		ladder = new LinkedList<String>();
		words = new Stack<String>();
		startWord = "";
		endWord = "";
	}
	
	public WordChain(String start, String end, String bruh) throws Exception
	{
		ladder = new LinkedList<String>();
		words = new Stack<String>();
		startWord = start;
		endWord = end;
		setDictionary(bruh);
	}
	
	public void setDictionary(String bruh) 
	{
		String[] bruh2 = bruh.split("\n");
		for(int i = 0; i < 127142; i++)
		{
			dictionary.add(bruh2[i]);
		}
	}
	
	
	
	@Override 
	public String toString()
	{
		return dictionary.toArray() + "";
	}
}
