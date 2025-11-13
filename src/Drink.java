
public class Drink extends MenuItem{
	//variable
	String size;
	
	//constructor
	public Drink(String name, Double price, int calories, String description,String size) {
		super(name, price, calories, description);
		this.size=size;
	}
	@Override
	public String getCategory() {
		return "Drink";
	}
	
	public String displayInfo() {
		return "Name: " +name +"Size: " +size +"Price: " +price +"Calories: " +calories +"Description: " +description;
	}
}
