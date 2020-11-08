package Application;

/**
 * This class represents a chicken sandwich
 * @author Steven Nguyen, Julian Romero
 */
public class Chicken extends Sandwich {
	// Ingredients in every chicken sandwich
	private static final String[] INCLUDED_INGREDIENTS = {
		"Fried Chicken",
		"Spicy Sauce",
		"Pickles"
	};
	
	// Cost of a chicken sandwich with no extras
	private static final double BASE_PRICE = 8.99;
	
	// Constructs a chicken sandwich with no extras
	public Chicken() {
		super();
	}
	
	// Calculates the cost
	public double price() {
		double extrasPrice = super.getPriceOfExtras();
		return BASE_PRICE + extrasPrice;
	}
	
	// Returns the included ingredients
	public String[] getIncluded() {
		return INCLUDED_INGREDIENTS;
	}
	
	// Gets the string form
	@Override
	public String toString() {
		String result = "";
		String extras = super.toString();
		
		for (String ingredient : INCLUDED_INGREDIENTS) {
			result += ingredient + " | ";
		}
		
		return result + extras;
	}
}