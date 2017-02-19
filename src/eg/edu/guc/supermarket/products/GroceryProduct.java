package eg.edu.guc.supermarket.products;

public class GroceryProduct {
	private final String name;
	private double price;
	private double discount;
	
	public GroceryProduct(String name, double price, double discount){
		this.name     = name;
		this.price    = price;
		this.discount = discount;
	}
	public String toString(){
		return "Name: " + this.name + "\n"
				 +"Price: " + this.price + "\n"
				  + "Discount: " + this.discount + " %";
				  	
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getName() {
		return name;
	}
	
	public final double getActualPrice(){
		double discountAmount = this.getPrice() * (this.getDiscount()/100);
		return this.getPrice() - discountAmount;
	}
	
	public boolean equals(Object p){
		if (!(p instanceof GroceryProduct)){
			return false;
		}
		GroceryProduct g = (GroceryProduct) p;
		return ((this.getName() == g.getName()) &&
				this.getPrice() == g.getPrice() &&
				this.getDiscount() == g.getDiscount());
	}
}
