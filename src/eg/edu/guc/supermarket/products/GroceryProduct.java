package eg.edu.guc.supermarket.products;

public class GroceryProduct {
	private final String name;
	private double price;
	private int discount;
	
	public GroceryProduct(String name, double price, int discount){
		this.name     = name;
		this.price    = price;
		this.discount = discount;
	}
	public String toString(){
		return "Name: " + this.name
				 +"Price: " + this.price + " L.E."
				  + "Discount: " + this.discount + " %";
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getName() {
		return name;
	}
	
}
