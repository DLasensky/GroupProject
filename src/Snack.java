
public class Snack extends MenuItem {
	//variables
	String brand;
	
	//constructor
	public Snack(String name, Double price, int calories, String description, String type, String brand) {
		super(name, price, calories, description);
		this.brand=brand;
	}

	//get methods
	@Override
	public String getCategory() {
		return "Snack";
	}
	
	public String displayInfo() {
		return "Name: " +name +"Brand: " +brand +"Price: " +price +"Calories: " +calories +"Description: " +description;
	}
}
