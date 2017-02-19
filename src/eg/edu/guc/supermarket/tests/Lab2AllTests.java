package eg.edu.guc.supermarket.tests;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import static org.junit.Assert.*;
import eg.edu.guc.supermarket.products.Beverage;
import eg.edu.guc.supermarket.products.DairyProduct;
import eg.edu.guc.supermarket.products.Drinkable;
import eg.edu.guc.supermarket.products.Fat;
import eg.edu.guc.supermarket.products.GroceryProduct;
import eg.edu.guc.supermarket.products.SugarLevel;

public class Lab2AllTests {
	
	//------------------------------------Test Abstraction----------------------------------------------------------------------
	@Test(timeout = 1000)
	public void testAbstraction() throws NoSuchMethodException
	{
		assertTrue(Modifier.isAbstract(GroceryProduct.class.getModifiers()));
		//private
		assertTrue(Modifier.isAbstract(GroceryProduct.class.getMethod("refrigerate", new Class[0]).getModifiers()));
	}
	//------------------------------------Test Interface----------------------------------------------------------------------
	
	@Test(timeout = 1000)
	    public final void testInterface() {
			
			assertEquals("Drinkable should be an Interface", 1537, Drinkable.class.getModifiers());
		
			Drinkable drink= new Beverage("Pepsi", 5, 0, SugarLevel.ADDED_SUGAR);
			Drinkable drink2= new Beverage("Pure Apple", 5, 0, SugarLevel.NO_ADDED_SUGAR);
			Drinkable drink3= new Beverage("Sprite", 5, 0, SugarLevel.LIGHT);
			Drinkable drink4= new Beverage("Pepsi", 5, 0, SugarLevel.ZERO);
		    assertFalse("A drink with added sugar is unhealthy", drink.isHealthy());
		    assertTrue("A drink with no sugar is healthy", drink2.isHealthy());
		    assertTrue("A drink with light sugar level is healthy", drink3.isHealthy());
		    assertTrue("A drink with zero sugar level is healthy", drink4.isHealthy());
	    }
	//---------------------------------------------------Checking Overloading----------------------------------------------------------------
	
	@Test(timeout = 1000)
	public void testOverloading(){
		assertTrue("The method \"getActualPrice(int extra)\" should be declared in the Beverage class", containsMethod(Beverage.class, "getActualPrice",new Class[]{double.class}));
	}
	//--------------------------------------Checking methods work correctly----------------------------------------------
	
	//test getActualPrice
	@Test(timeout = 1000)
	public void testGetActualPrice()
	{
		Beverage beverage= new Beverage("Schweppes Pomegranate", 10, 5, SugarLevel.ADDED_SUGAR);
		assertEquals("The actual price should be 9.0", 9.0, beverage.getActualPrice(5), 0.1);
	}
	//equals -> Dairy
	@Test//(timeout = 1000)
	public void testEqualsDairyProductPolymorphism()
	{
		DairyProduct milk1= new DairyProduct("Juhayna Milk", 10, 5, Fat.FULLCREAM);
		DairyProduct milk2= new DairyProduct("Juhayna Milk", 10, 5, Fat.FULLCREAM);
		DairyProduct milk3= new DairyProduct("Labanita", 10, 5, Fat.FULLCREAM);
		DairyProduct milk4= new DairyProduct("Juhayna Milk", 9, 5, Fat.FULLCREAM);
		DairyProduct milk5= new DairyProduct("Juhayna Milk", 9, 25, Fat.FULLCREAM);
		DairyProduct milk6= new DairyProduct("Juhayna Milk", 9, 25, Fat.SKIMMED);
		assertTrue("The two instances are equal", milk1.equals(milk2));
		assertFalse("The two instances are not equal, they have different names", milk1.equals(milk3));
		assertFalse("The two instances are not equal, they have different prices", milk1.equals(milk4));
		assertFalse("The two instances are not equal, they have different discounts", milk1.equals(milk5));
		assertFalse("The two instances are not equal, they have different fat levels", milk1.equals(milk6));
	}
	//equals -> Beverage
	//equals -> Dairy
	//private
	@Test(timeout = 1000)
	public void testEqualsBeveragePolymorphism()
	{
		assertTrue("The method \"equals\" should be declared in the GroceryProduct class", containsMethod(GroceryProduct.class, "equals", new Class[]{Object.class}));
		
		assertTrue("The method \"equals\" should be declared in the DairyProduct class", containsMethod(DairyProduct.class, "equals", new Class[]{Object.class}));
		
		assertTrue("The method \"equals\" should be declared in the Beverage class", containsMethod(Beverage.class, "equals", new Class[]{Object.class}));
		
		Beverage beverage1= new Beverage("Schweppes Pomegranate", 10, 5, SugarLevel.ADDED_SUGAR);
		Beverage beverage2= new Beverage("Schweppes Pomegranate", 10, 5, SugarLevel.ADDED_SUGAR);
		Beverage beverage3= new Beverage("Sprite", 10, 5, SugarLevel.ADDED_SUGAR);
		Beverage beverage4= new Beverage("Schweppes Pomegranate", 9, 5, SugarLevel.ADDED_SUGAR);
		Beverage beverage5= new Beverage("Schweppes Pomegranate", 9, 25, SugarLevel.ADDED_SUGAR);
		Beverage beverage6= new Beverage("Schweppes Pomegranate", 9, 25, SugarLevel.ADDED_SUGAR);
		assertTrue("The two instances are equal", beverage1.equals(beverage2));
		assertFalse("The two instances are not equal, they have different names", beverage1.equals(beverage3));
		assertFalse("The two instances are not equal, they have different prices", beverage1.equals(beverage4));
		assertFalse("The two instances are not equal, they have different discounts", beverage1.equals(beverage5));
		assertFalse("The two instances are not equal, they have different fat levels", beverage1.equals(beverage6));
	}
	//equals -> diff types
	//private
	@Test(timeout = 1000)
	public void testEqualsPolymorphism()
	{
		DairyProduct milk= new DairyProduct("Juhayna Milk", 10, 5, Fat.FULLCREAM);
		Beverage beverage= new Beverage("Schweppes Pomegranate", 10, 5, SugarLevel.ADDED_SUGAR);
		assertFalse("When comparing different types of grocery products, the method should return false with no exception", milk.equals(beverage));		
		assertFalse("When comparing different types of grocery products, the method should return false with no exception", beverage.equals(milk));
	}
	
	//--------------------------------------------Helper methods----------------------------------------------------------
	public static boolean containsMethod(Class c, String name, Class[] parameters){
		try{
			c.getDeclaredMethod(name, parameters);
			return true;
		}
		catch(NoSuchMethodException e){
			return false;
		}
	}
}
