import java.util.ArrayList;


public class Catalog {

	private String cName;//instance variables 
	private ArrayList<Item> catalog;

	public Catalog(String name) {
		cName = name;
	  catalog = new ArrayList<Item>();
	}


	public void add(Item item) {
		catalog.add(item);
	}

  //returns the size of the catalog
  //@Return the catalog size
	public int size() {
		return catalog.size();
	}

  //Returns the item at a given index
  //@Return the item object at given index
	public Item get(int index) {
		return catalog.get(index);
	}

  //Returns the name of the catalog
  //@Return catalog name
	public String getName() {
		return cName;
	}
}
