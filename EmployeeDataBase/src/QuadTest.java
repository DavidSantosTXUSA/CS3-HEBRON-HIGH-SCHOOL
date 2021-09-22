import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;
public class QuadTest {
  public static void main(String[] args) throws IOException
   {
   ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> IDs = new ArrayList<Integer>();
		Scanner key = new Scanner(new File("Large Data Set.txt"));
		while(key.hasNextLine()) {
			String[] data = key.nextLine().split(" ");
			IDs.add(Integer.parseInt(data[0]));
			names.add(data[1] + " " + data[2]);
		}
		double a = 0.67;
		EmployeeDatabaseQuadratic test = new EmployeeDatabaseQuadratic((int) ((double) names.size() / a));
		double buildTableTimer = System.nanoTime();
		for(int i = 0; i < names.size(); i++) {
			test.put(IDs.get(i), names.get(i));
		}
		buildTableTimer = System.currentTimeMillis();

		// Successful searching
		key = new Scanner(new File("Successful Search Records.txt"));
		names = new ArrayList<String>();
		IDs = new ArrayList<Integer>();
		while(key.hasNextLine()) {
			String[] data = key.nextLine().split(" ");
			IDs.add(Integer.parseInt(data[0]));
			names.add(data[1] + " " + data[2]);
		}
		int successfulSize = names.size();
		double successfulSearchTimer = System.currentTimeMillis();
		for(int i = 0; i < names.size(); i++) {
			Employee temp = test.get(IDs.get(i));
		}
		successfulSearchTimer = System.currentTimeMillis();
		int successfulProbes = test.currentProbes;
		test.resetCurrentProbes();

		// Unsuccessful searching
		key = new Scanner(new File("Unsuccessful Search Records.txt"));
		names = new ArrayList<String>();
		IDs = new ArrayList<Integer>();
		while(key.hasNextLine()) {
			String[] data = key.nextLine().split(" ");
			IDs.add(Integer.parseInt(data[0]));
			names.add(data[1] + " " + data[2]);
		}
		int unsuccessfulSize = names.size();
		double unsuccessfulSearchTimer = System.currentTimeMillis();
		for(int i = 0; i < names.size(); i++) {
			Employee temp = test.get(IDs.get(i));
		}
		unsuccessfulSearchTimer = System.currentTimeMillis();
		int unsuccessfulProbes = test.currentProbes;
		test.resetCurrentProbes();

		// Output
		PrintWriter output = new PrintWriter(new FileOutputStream("quadTester.txt"));
				output.println("Type of Hashing: Quadratic Probing");
		output.println("\nHash Function Used: int) ((((long) ID * ID) / 1200L) % hashTable.length)");
		output.println("\nNumber of records added to the table: 50000 \nTable Size: " + test.hashTable.length + "\nLoad Factor: " + a);
		output.println("\nTotal Insertion Time: " + buildTableTimer + " seconds\n" + "Average Insertion time per element: " + buildTableTimer / test.size + " seconds");
		output.println("\nTotal Table Insertion Collisions: " + 
		test.collisionCounter  + "\nAverage Table Insertion Collisions: " + (double) test.collisionCounter / test.size);
		output.println("\nNumber of collisions vs. Number of Insertions: "  +  ((double) test.collisionCounter / test.size) * 100.0 + "%");
		output.println("\nTotal Successful Search Time: " + successfulSearchTimer + " seconds\nAverage Successful Search Time: " + ((double) successfulSearchTimer / successfulSize) + " seconds\nTotal Probes Needed: " + successfulProbes + "\nAverage Probes Needed: " + (double) successfulProbes / successfulSize);
		output.println("\nTotal Unsuccessful Search Time: " + unsuccessfulSearchTimer + " seconds\nAverage Unsuccessful Search Time: " + ((double) unsuccessfulSearchTimer / unsuccessfulSize) + " seconds\nTotal Probes Needed: " + unsuccessfulProbes + "\nAverage Probes Needed: " + (double) unsuccessfulProbes / unsuccessfulSize);
		output.println("Type of Hashing: Quadratic Probing");
		output.println("\nHash Function Used: int) ((((long) ID * ID) / 1200L) % hashTable.length)");
		output.println("\nNumber of records added to the table: 50000 \nTable Size: " + test.hashTable.length + "\nLoad Factor: " + a);
		output.println("\nAverage Insertion time: " + buildTableTimer / test.size + " seconds");
		output.println("\nTotal Table Insertion Collisions: " + 
		test.collisionCounter  + "\nAverage Table Insertion Collisions: " + (double) test.collisionCounter / test.size);
		output.println("\nNumber of collisions vs. Number of Insertions: "  +  ((double) test.collisionCounter / test.size) * 100.0 + "%");
		output.println("\nTotal Successful Search Time: " + successfulSearchTimer + " seconds\nAverage Successful Search Time: " + ((double) successfulSearchTimer / successfulSize) + " seconds\nTotal Probes Needed: " + successfulProbes + "\nAverage Probes Needed: " + (double) successfulProbes / successfulSize);
		output.println("\nTotal Unsuccessful Search Time: " + unsuccessfulSearchTimer + " seconds\nAverage Unsuccessful Search Time: " + ((double) unsuccessfulSearchTimer / unsuccessfulSize) + " seconds\nTotal Probes Needed: " + unsuccessfulProbes + "\nAverage Probes Needed: " + (double) unsuccessfulProbes / unsuccessfulSize);
		output.close();
				System.out.println("Type of Hashing: Quadratic Probing");
		System.out.println("\nHash Function Used: int) ((((long) ID * ID) / 1200L) % hashTable.length)");
		System.out.println("\nNumber of records added to the table: 50000 \nTable Size: " + test.hashTable.length + "\nLoad Factor: " + a);
		System.out.println("\nTotal Insertion Time: " + buildTableTimer + " seconds\n" + "Average Insertion time per element: " + buildTableTimer / test.size + " seconds");
		System.out.println("\nTotal Table Insertion Collisions: " + 
		test.collisionCounter  + "\nAverage Table Insertion Collisions: " + (double) test.collisionCounter / test.size);
		System.out.println("\nNumber of collisions vs. Number of Insertions: "  +  ((double) test.collisionCounter / test.size) * 100.0 + "%");
		System.out.println("\nTotal Successful Search Time: " + successfulSearchTimer + " seconds\nAverage Successful Search Time: " + ((double) successfulSearchTimer / successfulSize) + " seconds\nTotal Probes Needed: " + successfulProbes + "\nAverage Probes Needed: " + (double) successfulProbes / successfulSize);
		System.out.println("\nTotal Unsuccessful Search Time: " + unsuccessfulSearchTimer + " seconds\nAverage Unsuccessful Search Time: " + ((double) unsuccessfulSearchTimer / unsuccessfulSize) + " seconds\nTotal Probes Needed: " + unsuccessfulProbes + "\nAverage Probes Needed: " + (double) unsuccessfulProbes / unsuccessfulSize);
  }
}