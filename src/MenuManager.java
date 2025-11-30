import java.util.ArrayList;
import java.util.List;

// Stores menu items and filters them

public class MenuManager {
	
    private ArrayList<MenuItem> items = new ArrayList<MenuItem>();

    public void addItem(MenuItem item) {
    	
        if (item != null) {
        	
            items.add(item);
            
        }
    }

    public List<MenuItem> getAllItems() {
    	
        return new ArrayList<MenuItem>(items);
        
    }

    public List<MenuItem> filterItems(String category) {
    	
        ArrayList<MenuItem> result = new ArrayList<MenuItem>();
        
        for (MenuItem item : items) {
        	
            if (item.getCategory().equalsIgnoreCase(category)) {
            	
                result.add(item);
                
            }
        }
        
        return result;
        
    }
    
    //remove item permanently from list when selected by Remove Item panel.
    public void removeItem(MenuItem item) {
    	items.remove(item);
    }
}