public class EmployeeDatabaseQuadratic {
	
	class Entry {
		int ID;				
		Employee employee;	

		public Entry(int ID, Employee emp) { this.ID = ID; employee = emp; }
		@Override
		public String toString() { return "" + this.ID + " - " + employee.getName(); }
	}
	
	public Entry[] hashTable;

	public int collisionCounter;

	public int size;

	public int currentProbes;
	
	public EmployeeDatabaseQuadratic() {
		this.size = 0;
		collisionCounter = 0;
		currentProbes = 0;
	  hashTable = new Entry[10];
	}
	
	public EmployeeDatabaseQuadratic(int size) {
		this.size = 0;
		collisionCounter = 0;
		currentProbes = 0;
		hashTable = new Entry[size];
	}
	
	public int hashCode(int ID) {
		
		//return ID%100;
		return (int) ((((long) ID * ID) / 1200L) % hashTable.length);
	}
	
	public Employee put(int key, String val) {
		Employee emp = new Employee(val);
		int i = this.hashCode(key);
		int count = 0;
		do {
			if(this.hashTable[i] == null) {
				Entry temp = new Entry(key, emp);
				hashTable[i] = temp;
				size++;
				return emp;
			}
			else { 
			  this.collisionCounter++; 
			}
			count++;
			i = (int) (i + ((long) count * count)) % hashTable.length;
		} while(hashTable[i]!=null);
		return null;
	}
	
	public Employee get(int key) {
		int count = 0;
		int i = hashCode(key);
		do {
			currentProbes++;
			if(count == hashTable.length) {
				
				break;
			}
			else if(hashTable[i] == null) {
				
				break;
			}
			else if(hashTable[i].ID == key) {
				return hashTable[i].employee;
			}
			count++;
			i = (int) (i + ((long) count * count))%hashTable.length;
			
		} while(hashTable[i]!=null);
		return null;
	}
	
	@Override
	public String toString() {
		String output = "";
		for(Entry temp : this.hashTable) {
			output += temp + "\n";
		}
		return output;
	}
	
	public void resetCurrentProbes() {
		currentProbes = 0;
	}
} 