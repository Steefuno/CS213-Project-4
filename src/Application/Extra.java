package Application;

/**
 * This class represents an extra ingredient to equip to a sandwich
 * @author Steven Nguyen, Julian Romero
 */
public class Extra {
	// Options for Extra ingredients that may be added to the sandwich
	private static final String[] AvailableExtrasOptions = {
		"Tomato",
		"Onion",
		"Cheese",
		"Cucumber",
		"Mushroom",
		"Bacon",
		"Mayonnaise",
		"Mustard",
		"Tangy Sauce",
		"Celery",
		"Leek",
		"HAM",
		"Mint",
		"Bibbs"
	};
	
	// The name of the ingredient
	private String ingredient;
	
	// Constructs an extra
	public Extra(String _ingredient) {
		this.ingredient = _ingredient;
	}
	
	// Getter for AvailableExtrasOptions
	public static String[] getAvailableExtrasOptions() {
		return AvailableExtrasOptions;
	}
	
	// Gets the string form
	@Override
	public String toString() {
		return ingredient;
	}
}
