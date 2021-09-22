import java.util.ArrayList;

public class ShoppingCart {

	private ArrayList<ItemOrder> shopList;//instance variables 

	public ShoppingCart() {
		shopList = new ArrayList<ItemOrder>();
	}

	public void add(ItemOrder newOrder) {
		if(shopList.contains(newOrder)) //if the new order is the same then remove the last order
    {
			shopList.remove(newOrder);
		}
		shopList.add(newOrder);
	}
  //Returns the total cost of the shopping cart ItemOrder
  //@Return the total
	public double getTotal() {
		double total = 0.0;
		for(int i = 0; i < shopList.size(); i++) {
			total += shopList.get(i).getPrice();
		}
		return total;
	}
}
