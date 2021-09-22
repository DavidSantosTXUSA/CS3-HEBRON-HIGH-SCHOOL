public class EmployeeDatabaseLinear {
	
	/**
	 * private inner class 
	 * stores the ID integer 
	 * and the employee Object
	 * attached to it
	 */
	class Entry {
		int ID;				
		Employee employee;	
		
		public Entry(int ID, Employee emp) 
		{ 
		  this.ID = ID; 
		  employee = emp;
		  }
		  
		@Override
		public String toString() 
		{ 
		  return "" + this.ID + " - " + employee.getName(); 
		}
	}
	
	//backing array
	public Entry[] hashTable;

  //number of collisions
	public int collisionCounter;
	
	//size of the array
	public int size;

  //number of current probes 
	public int currentProbes;

  /**
   * default constructor 
   * sets everything to 0
   * and the backing array
   * to a big enough starting number
   */
	public EmployeeDatabaseLinear() {
		this.size = 0;
		collisionCounter = 0;
		currentProbes = 0;
		hashTable = new Entry[42069];
	}

  /**
   * overloaded constructor
   * takes in parameter int size
   * and sets the backing array
   * to that size. sets everything 
   * to default values
   * @Param int size
   */
	public EmployeeDatabaseLinear(int size) {
		this.size = 0;
		collisionCounter = 0;
		currentProbes = 0;
		hashTable = new Entry[size];
	}

/**
 * gives hashcodes 0-9
 */
	public int hashCode(int ID) {
		return ID%10;
	}
	
	public Employee put(int key, String val) {
		Employee emp = new Employee(val);
		int i = hashCode(key);
		int count = 0;
		do {
			if(count == this.hashTable.length) {
				break;
			}
			if(this.hashTable[i] == null) {//if empty space then add
				Entry temp = new Entry(key, emp);
				hashTable[i] = temp;
				size++;
				return emp;
			}
			else { //no empty space meaning we have collision
			  collisionCounter++; 
			}
			i = (i + 1);//go to next index
			count++;
		} while(hashTable[i]!=null);
		return null;
	}

  /**
   *returns the employee object at the given key
   * @param int key
   * @return employee e
   */
	public Employee get(int key) {
		int count = 0;
		int i = hashCode(key);
		do {
			currentProbes++;
			if(this.hashTable[i].ID == key) {
				return this.hashTable[i].employee;
			}
			i = (i + 1);
			count++;
		} while(hashTable[i]!=null);
		return null;
	}
	@Override
	public String toString() {
		String output = "";
		for(Entry temp : hashTable) {
			output += temp + "\n";
		}
		return output;
	}

/**
 * resets probes
 */ 
	public void resetCurrentProbes() {
		currentProbes = 0;
	}
} 