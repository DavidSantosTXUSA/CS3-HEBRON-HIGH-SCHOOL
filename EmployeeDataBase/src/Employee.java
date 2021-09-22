public class Employee {
	public String name;//name of employee
	/**
	 * constuctor that sets the employees name
	 */
	public Employee(String name) {
		this.name = name;
	}
	/**
	 * returns name
	 */ 
	public String getName()
	{
	  return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}