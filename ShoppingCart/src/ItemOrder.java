public class ItemOrder {

	private Item item;

	private int quantity;//instance variables 

	public ItemOrder(Item item, int qty) {
		this.item = item;
		this.quantity = qty;
	}

  //Calls and Returns the priceFor method
  //@Return the priceFor method output
	public double getPrice() {
		return item.priceFor(quantity);
	}

  //Returns the item Object
  //@Return item Object
	public Item getItem() {
		return item;
	}
	@Override
  //Returns true if the item object equals the ItemOrder temp object
  //@Return true if the item object equals the ItemOrder temp object
	public boolean equals(Object obj) {
		ItemOrder bruh = (ItemOrder) obj;
		return this.item.equals(bruh.item);
	}
}
