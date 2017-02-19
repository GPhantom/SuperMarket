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
	
	@Override
	public boolean equals(Object p){
		if (!(p instanceof DairyProduct)){
			return false;
		}
		DairyProduct g = (DairyProduct) p;
		return (this.getName() == g.getName() &&
				this.getPrice() == g.getPrice() &&
				this.getDiscount() == g.getDiscount() &&
				this.f == g.f);
	}
	
	@Override
	public boolean refrigerate() {
		return true;
	}
	

}
