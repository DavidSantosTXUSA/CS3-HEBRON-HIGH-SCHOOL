
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class uses the Zuckendorf theorem to a Arraylist of numbers
 * in order to get a Fibonacci sequence for each number.
 */
public class Zeckendorf
{
  private ArrayList<Integer> integers = new ArrayList<>();
  
  /**
   * Returns the next number in the Fibonacci sequence 
   * @para number to find the Fibonacci sequence of number
   * @return Fibonacci sequence of the number
   */
  public int nextNum(int n)
  {
    int num = 0;
    int num2 = 1;
    int num3 = 1;
    do{ //does the fibonacci sequence until we reach n
      num = num2;
      num2 = num3;
      num3 = num + num2;
    }while(num3 <= n);
    return num2;
  }
  
    /**
   * uses the file and puts it into an ArrayList of values
   * @param list of numbers to find Zeckendorf
   * @return the arrays that contain the values that sum up to the number with Zuckendorf's Theorem
   */
    public void zeck(String filename) throws FileNotFoundException
  {
    File file = new File(filename);   //Creates flie object
    Scanner scan = new Scanner(file);
    while (scan.hasNext()) { //while there is another number in the list, read its data
        if (scan.hasNextInt()) {
            integers.add(scan.nextInt());//adds to arraylist
        } 
        else {
        	scan.next();//skip if nothing is there
        }
    }
    integers.remove(0);
    zuckendorfArray(integers);
  }
  
  /**
   * Takes all the values in the file and goes through the number and uses the nextNum
   * method to take all the values and put it into an array list.
   * @param the array with the values to obtain the Zuckendorf Theorem of
   * @return the arrays that contain the new values that sum up to the number with Zuckendorf's Theorem
   */
  public void zuckendorfArray(ArrayList<Integer> arr)
  {
    int num = 0;
    ArrayList<Integer> zuckArray = new ArrayList<Integer>();
    ArrayList<Integer> zuckArray2 = new ArrayList<Integer>();
    for(int i = 0; i < arr.size(); i++) //Loops through the integers array
    {
      num = arr.get(i);
      while(arr.get(i) > 0) //Makes sure the arrays is > 0
      {
        int fibNum = nextNum(arr.get(i)); //Stores the values into the array
        zuckArray.add(fibNum);
        arr.set(i, (arr.get(i) - fibNum));
      }
      
      for(int j = zuckArray.size()-1; j >= 0; j--)
      {
        zuckArray2.add(zuckArray.get(j)); //Adds the values to the second array
      }
      System.out.print(num + " = "); 
      for(int k = 0; k < zuckArray2.size(); k++)
      {
        if(k == zuckArray2.size()-1)
        {
          System.out.print(zuckArray2.get(k));
        }
        else
        {
          System.out.print(zuckArray2.get(k) + " + ");
        }
      }
      System.out.println();
      zuckArray.clear(); 
      zuckArray2.clear();//Clears the arrays so that it can loop back through the values and return its digits 
    }
  }
}
