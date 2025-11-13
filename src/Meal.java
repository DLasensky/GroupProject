
public class Meal extends MenuItem {
	//variables
	String type;
	
	//constructor
	public Meal(String name, Double price, int calories, String description, String type) {
		super(name, price, calories, description);
		this.type=type;
	}

	//get methods
	@Override
	public String getCategory() {
		return "Meal";
	}
	
	public String displayInfo() {
		return "Name: " +name +"Type: " +type +"Price: " +price +"Calories: " +calories +"Description: " +description;
	}

}
