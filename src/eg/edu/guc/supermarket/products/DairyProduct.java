package eg.edu.guc.supermarket.products;

public class DairyProduct extends GroceryProduct{
	FatLevel f;
	
	public DairyProduct(String name, double price, double discount, FatLevel f){
		super(name, price, discount);
		this.f = f;
	}
	
	public String toString(){
		return super.toString() + "\n" + "Fat Level: " + this.f;
	}
	
	public boolean equals(DairyProduct p){
		return ((this.getName() == p.getName()) &&
				this.getPrice() == p.getPrice() &&
				this.getDiscount() == p.getDiscount());
	}
	

}
