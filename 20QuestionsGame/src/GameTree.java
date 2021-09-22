import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GameTree
{

	/**
	 * Will you need to create an inner class?
	 */
	// TODO?
	/**
	 * Private inner class 
	 * that contains the info 
	 * on each node and its children
	 */
	private class BinaryTreeNode
	{
		String word;
		BinaryTreeNode left, right;

		BinaryTreeNode()
		{
			word = null;
			left = right = null;
		}

		BinaryTreeNode(String word)
		{
			this.word = word;
			left = right = null;
		}

		@Override
		public String toString()
		{
			return "" + this.word;
		}
	}

	/**
	 * Will you need any instance variables?
	 */
	// TODO?
	/*
	 * private instance variables 
	 * for the overall root, current
	 * root and a string name for
	 * the file to use when we save
	 * the file
	 */
	private BinaryTreeNode overallRoot;
	private BinaryTreeNode current;
	private String file;

	/**
	 * Constructor needed to create the game.
	 * Calls a private helper method to recursivly 
	 * load in the file
	 * @param fileName this is the name of the file we need to import the game
	 *                 questions and answers from.
	 */
	public GameTree(String fileName)
	{

		try
		{
			file = fileName;
			Scanner key = new Scanner(new File(fileName));
			overallRoot = new BinaryTreeNode();
			loadFile(overallRoot, fileName);
			current = overallRoot;
		} catch (FileNotFoundException s)
		{
			System.out.println("File does Not Exist Please Try Again: ");
		}
	}

	/**
	 * private helper method
	 * uses recursion to load 
	 * in the file into the tree
	 * @param currentNode
	 * @param scan
	 * @throws FileNotFoundException 
	 */
	private void loadFile(BinaryTreeNode currentNode, String fileName) throws FileNotFoundException
	{
		Scanner key = new Scanner(new File(fileName));
		if (key.hasNextLine())
		{
			String line = key.nextLine();
			currentNode.word = line;
			if (currentNode.word.contains("?"))
			{
				BinaryTreeNode left = new BinaryTreeNode();
				currentNode.left = left;
				BinaryTreeNode right = new BinaryTreeNode();
				currentNode.right = right;
				loadFile(left, fileName);
				loadFile(right, fileName);
			}
		}
	}

	/*
	 * Add a new question and answer to the currentNode. If the current node has the
	 * answer chicken, theGame.add("Does it swim?", "goose"); should change that
	 * node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * Adds a new question and answer pair to the tree
	 * questions go to the left answers go to right
	 * @param newQ The question to add where the old answer was.
	 * @param newA The new Yes answer for the new question.
	 */
	public void add(String newQ, String newA)
	{
		String currA = current.word;
		current.word = newQ;
		BinaryTreeNode left = new BinaryTreeNode(newA);
		BinaryTreeNode right = new BinaryTreeNode(currA);
		current.left = left;
		current.right = right;
	}

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 * Uses a contains() to determine this
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer()
	{
		return !current.word.contains("?");
	}

	/**
	 * Return the data for the current node, which could be a question or an answer.
	 * Current will change based on the users progress through the game.
	 * returns current
	 * @return The current question or answer.
	 */
	public String getCurrent()
	{
		return current.word;
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or right
	 * for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo)
	{
		if (yesOrNo == Choice.Yes)
		{
			current = current.left;
		} else
		{
			current = current.right;
		}
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the question
	 * at the root of this GameTree.
	 */
	public void reStart()
	{
		current = overallRoot;
	}

	/**
	 * toString method
	 */
	@Override
	public String toString()
	{
		return print(overallRoot, "", 0);
	}

	/**
	 * Helper method for toString()
	 * uses recursion to output the dashes
	 * uses recursion to go through the tree
	 * parameters are the current node
	 * the output and the depth we are 
	 * at on the binary tree
	 * @param node 
	 * @param output
	 * @param depth
	 * @return
	 */
	private String print(BinaryTreeNode node, String output, int depth)
	{
		if (node != null)
		{
			output = print(node.left, output, depth+1);
			for(int i = 0; i < depth; i++)
			{
				output+=("- ");
			}
			output += node.word + "\n";
			output = print(node.right, output, depth+1);
		}
		
		return output;
	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may have
	 * new questions added since the game started.
	 *
	 */
	public void saveGame()
	{
		try
		{
			PrintWriter diskFile = new PrintWriter(new File(file));
			save(overallRoot, diskFile);
			diskFile.close();
		} catch (FileNotFoundException e)
		{
			
		}
	}

	private void save(BinaryTreeNode node, PrintWriter diskFile)
	{
		if (node != null)
		{
			diskFile.println(node.word);
			save(node.left, diskFile);
			save(node.right, diskFile);
		}
	}

}
