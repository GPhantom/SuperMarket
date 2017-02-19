package eg.edu.guc.supermarket.products;

public class Beverage extends GroceryProduct implements Drinkable{
	
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
	
	@Override
	public boolean equals(Object p){
		if (!(p instanceof Beverage)){
			return false;
		}
		Beverage g = (Beverage) p;
		return (this.getName() == g.getName() &&
				this.getPrice() == g.getPrice() &&
				this.getDiscount() == g.getDiscount() &&
				this.s == g.s);
	}
	
	@Override
	public boolean refrigerate() {
		return false;
	}
	
	public boolean isHealthy(){
		return (this.s != SugarLevel.ADDED_SUGAR);
	}

}
