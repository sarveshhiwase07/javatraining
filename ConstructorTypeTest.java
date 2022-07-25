public class ConstructorTypeTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String itemsList[] = {"Garnier Shampoo","Face wash","Lays Chips"};
		ShoppingCart cartObj = new ShoppingCart(itemsList,"Reliance Mart");
		cartObj.printCart();
		cartObj.addItemToCart("Gajia Broom");
		cartObj.printCart();
		cartObj.removeItemFromCart();
		cartObj.printCart();
	}
}

class ShoppingCart{
	private String shopName;
	private String[] items;
	private double totalCartAmount;
	//shopping cart with empty list and default shop name
	ShoppingCart(){
		items = new String[0];
		shopName = "D-Mart";
		totalCartAmount = 0;
	}
	//shopping cart with intialised list
	ShoppingCart(String[] items,String shopName){
		this.items = items;
		this.shopName = shopName;
		for(String s: items) totalCartAmount += 50;
	}
	
	//add item to an cart
	void addItemToCart(String item) {
		String itemsDuplicate[] = new String[this.items.length + 1];
		for(int i = 0; i < this.items.length; i++) {
			itemsDuplicate[i] = this.items[i];
		}
		itemsDuplicate[itemsDuplicate.length - 1] = item;
		items = itemsDuplicate;
		totalCartAmount += 50;
	}
	
	//remove item from cart
	void removeItemFromCart() {
		String itemsDuplicate[] = new String[this.items.length - 1];
		for(int i = 0; i < this.items.length - 1; i++) {
			itemsDuplicate[i] = this.items[i];
		}
		items = itemsDuplicate;
		totalCartAmount -= 50;
	}
	//return total cart price
	double getTotalPrice() {
		return totalCartAmount;
	}
	//print all cart
	void printCart() {
		System.out.println("Cart Details: ");
		System.out.println("Shop Name: " + shopName);
		System.out.println("Items in your cart:");
		for(String s: items) {
			System.out.println(s);
		}
		System.out.println("Total Cart Amount: " + totalCartAmount);
		System.out.println("-------------------------------------------------------------------");
	}
}