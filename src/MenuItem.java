
public abstract class MenuItem {
	//variables
	String name;
	Double price;
	int calories;
	String description;
	
	//constructor
	public MenuItem(String name, Double price, int calories, String description) {
		this.name=name;
		this.price=price;
		this.calories=calories;
		this.description=description;
	}
	
	//get methods
	public String getName() {
		return name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public int getCalories() {
		return calories;
	}
	
	public String getDescription() {
		return description;
	}
	
	abstract String getCategory();
}
