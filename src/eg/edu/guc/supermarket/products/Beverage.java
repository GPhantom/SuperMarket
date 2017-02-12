package eg.edu.guc.supermarket.products;

public class Beverage extends GroceryProduct{
	
	SugarLevel s;
	
	public Beverage(String name, double price, int discount, SugarLevel s){
		super(name, price, discount);
		this.s = s;
	}
	public String toString(){
		return super.toString() + "SugarLevel " + this.s;
	}

}