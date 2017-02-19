package eg.edu.guc.supermarket.products;

public class Beverage extends GroceryProduct{
	
	SugarLevel s;
	
	public Beverage(String name, double price, double discount, SugarLevel s){
		super(name, price, discount);
		this.s = s;
	}
	public String toString(){
		return super.toString() + "\n" + "Sugar Level: " + this.s;
	}
	
	public double getActualPrice(double extra){
		double finalprice = this.getPrice() - (this.getPrice() * ((this.getDiscount() + extra) / 100));
		return finalprice;
	}

}
