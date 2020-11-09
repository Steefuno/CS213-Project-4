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
		"Chives",
		"Cucumber",
		"Mushroom",
		"Bacon",
		"Mayonnaise",
		"Mustard",
		"Tangy Sauce",
		"Celery",
		"Leek",
		// The below ingredients are me messing around
		"HAM",
		"Toes",
		"Cat Tears",
		// The below ingredients are friends of mine
		"Bibbs",
		"Shioya"
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
