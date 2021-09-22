public class Item {

	private String name;//instance variables 
	private double price;
	private int bulkQty;
	private double bulkPrice;

	public Item(String name, double price) {
		this(name, price, 0, price);
	}

	public Item(String name, double price, int bulkQty, double bulkPrice) {
		if(price < 0 || bulkQty < 0 || bulkPrice < 0) {
			throw new IllegalArgumentException("Error");
		}
			this.name = name;
			this.price = price;
			this.bulkQty = bulkQty;
			this.bulkPrice = bulkPrice;
	}

  //Returns the price for a item given a quantity
  //This method should determine if a bulkdiscount should apply
  //@Param the quantity of the item
  //@Return the total price
	public double priceFor(int quantity) {
		if(quantity < 0) {
			throw new IllegalArgumentException("Error");
		}
		else {
			if(quantity >= bulkQty) {
				return bulkPrice * quantity;
			}
				return price * quantity;
		}
	}

	@Override
  //Equals method which will return true if the names of the items are the same
  //@Param item Object
  //@Return true if name equals the other item object name
	public boolean equals(Object obj) {
		Item bruh = (Item) obj;
		return this.name.equals(bruh.name);
	}

	@Override
  //Returns a readable summary of the Item data that includes the name and price and if 
  //Appclipable , return the bulkqty and bulkprice 
  //@Return name and price or name,price,bulkqty,and bulkPrice
	public String toString() {
		if(bulkQty==0)
    {	
				return name + ", $" + price;
    }
    return name + ", $" + price + ", (" + bulkQty + " for $" + bulkPrice +")";
	}
}
