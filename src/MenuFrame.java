import javax.swing.*;
import java.awt.event.*;
import java.util.List;

/*
 *  cafe window with a simple list and filters
 */

public class MenuFrame extends JFrame {

    private LoginFrame loginRef;
    private MenuManager menuManager;
    private DefaultListModel<String> listModel;
    private JList<String> list;

    //set up main panel
    public MenuFrame(LoginFrame loginRef) {
    	
        this.loginRef = loginRef;

        setTitle("RollinsCafe - Menu");
        setSize(500, 380);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("RollinsCafe Menu");
        heading.setBounds(190, 10, 200, 25);
        add(heading);

        menuManager = new MenuManager();
        loadSampleData();
        
        //add scrollable table to main panel
        listModel = new DefaultListModel<String>();
        list = new JList<String>(listModel);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setBounds(30, 50, 430, 200);
        add(scroll);
        //add buttons for main panel
        JButton allBtn = new JButton("All");
        allBtn.setBounds(30, 270, 90, 30);
        add(allBtn);

        JButton drinksBtn = new JButton("Drinks");
        drinksBtn.setBounds(130, 270, 90, 30);
        add(drinksBtn);

        JButton mealsBtn = new JButton("Meals");
        mealsBtn.setBounds(230, 270, 90, 30);
        add(mealsBtn);

        JButton snacksBtn = new JButton("Snacks");
        snacksBtn.setBounds(330, 270, 90, 30);
        add(snacksBtn);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(200, 310, 90, 25);
        add(logoutBtn);
        
        JButton addBtn = new JButton("Add");
        addBtn.setBounds(100,310,90,25);
        add(addBtn);
        
        JButton removeBtn = new JButton("Remove");
        removeBtn.setBounds(300,310,90,25);
        add(removeBtn);
        
        //add Action Listeners for buttons in main panel
        allBtn.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	
                showItems(menuManager.getAllItems());
                
            }
        });
        
        drinksBtn.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	
                showItems(menuManager.filterItems("Drink"));
                
            }
        });
        
        mealsBtn.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	
                showItems(menuManager.filterItems("Meal"));
                
            }
        });
        
        snacksBtn.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	
                showItems(menuManager.filterItems("Snack"));
                
            }
        });
        
        logoutBtn.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	
                // hide menu and show login again
            	
                setVisible(false);
                loginRef.setVisible(true);
                
            }
        });
        
  //call Add and Remove dialog panels when buttons are pressed from main panel
        addBtn.addActionListener(e-> openAddItemDialog());
        removeBtn.addActionListener(e-> openRemoveDialog());
        showItems(menuManager.getAllItems());

        setLocationRelativeTo(null);
        
    }

    private void loadSampleData() {
    	
        menuManager.addItem(new Drink("Iced Coffee", 3.49, 80, "Cold brew over ice", "Medium"));
        menuManager.addItem(new Drink("Orange Juice", 2.99, 110, "Fresh squeezed", "Small"));
        menuManager.addItem(new Meal("Chicken Wrap", 7.99, 520, "Grilled chicken with veggies", "Wrap"));
        menuManager.addItem(new Meal("Veggie Bowl", 8.49, 430, "Rice, beans, veggies", "Bowl"));
        menuManager.addItem(new Snack("Chips", 1.99, 150, "Sea salt chips", "CrunchCo"));
        menuManager.addItem(new Snack("Granola Bar", 1.49, 190, "Oats and honey", "SunnyBites"));
        menuManager.addItem(new Snack("Tuna Sushi", 8.99, 255, "Fresh Tuna with Ginger", "Sushi"));
        menuManager.addItem(new Drink("Cappuccino", 4.29, 120, "Espresso with steamed milk foam", "Medium"));
        menuManager.addItem(new Drink("Green Tea", 2.79, 0, "Light and refreshing herbal tea", "Large"));
        menuManager.addItem(new Drink("Mocha", 4.99, 210, "Chocolate-infused espresso with milk", "Medium"));
        menuManager.addItem(new Drink("Lemonade", 3.29, 140, "House-made sweet lemonade", "Large"));
        menuManager.addItem(new Drink("Matcha Latte", 5.49, 180, "Creamy matcha green tea", "Medium"));
        menuManager.addItem(new Meal("Beef Tacos", 9.49, 610, "Two tacos with seasoned beef and salsa", "Taco"));
        menuManager.addItem(new Meal("Caesar Salad", 8.99, 380, "Romaine, croutons, parmesan, dressing", "Salad"));
        menuManager.addItem(new Meal("BBQ Burger", 10.99, 720, "Beef patty with BBQ sauce and onion rings", "Burger"));
        menuManager.addItem(new Meal("Pasta Primavera", 9.99, 560, "Pasta with seasonal vegetables and olive oil", "Pasta"));
        menuManager.addItem(new Meal("Fish & Chips", 11.49, 800, "Battered fish with fries", "Entree"));
        menuManager.addItem(new Snack("Apple Slices", 1.79, 80, "Fresh-cut apple slices", "FreshFruit"));
        menuManager.addItem(new Snack("Yogurt Parfait", 3.99, 220, "Granola, yogurt, and berries", "SweetTreat"));
        menuManager.addItem(new Snack("Pretzel Bites", 2.49, 170, "Soft pretzel bites with cheese dip", "SnackCo"));
        menuManager.addItem(new Snack("Dark Chocolate", 1.29, 160, "Rich dark chocolate square", "ChocoLux"));
        menuManager.addItem(new Snack("Edamame", 3.49, 190, "Steamed soybeans with sea salt", "AsianBites"));
    }

    //allows the menu to be displayed
    private void showItems(List<MenuItem> items) {
    	
        listModel.clear();
        for (MenuItem mi : items) {
        	
            listModel.addElement(mi.displayInfo());
            
        }}
    
    //Add panel from add button on main
    private void openAddItemDialog() {
    	JDialog dialog = new JDialog(this, "Add Menu Item", true);
    	dialog.setSize(300,350);
    	dialog.setLayout(null);
    	dialog.setLocationRelativeTo(this);
    	
    	//adds labels, fields, etc.
    	JLabel nameLabel = new JLabel("Name:");
    	nameLabel.setBounds(20,20,80,25);
    	dialog.add(nameLabel);
    	
    	JTextField nameField = new JTextField();
    	nameField.setBounds(100,20,150,25);
    	dialog.add(nameField);
    	
    	JLabel priceLabel = new JLabel("Price:");
    	priceLabel.setBounds(20,60,80,25);
    	dialog.add(priceLabel);
    	
    	JTextField priceField = new JTextField();
    	priceField.setBounds(100,60,150,25);
    	dialog.add(priceField);
    	
    	JLabel calLabel = new JLabel("Calories:");
    	calLabel.setBounds(20,100,80,25);
    	dialog.add(calLabel);
    	
    	JTextField calField = new JTextField();
    	calField.setBounds(100,100,150,25);
    	dialog.add(calField);
    	
    	JLabel descLabel = new JLabel("Description:");
    	descLabel.setBounds(20,140,80,25);
    	dialog.add(descLabel);
    	
    	JTextField descField = new JTextField();
    	descField.setBounds(100,140,150,25);
    	dialog.add(descField);
    	
    	JLabel catLabel = new JLabel("Category:");
    	catLabel.setBounds(20,220,150,25);
    	dialog.add(catLabel);
    	
    	//scrollable box for category list
    	JComboBox<String> categoryBox = new JComboBox<>(new String[] {"Drink","Snack","Meal"});
    	categoryBox.setBounds(100,220,150,25);
    	dialog.add(categoryBox);
    	
    	JLabel extraLabel = new JLabel("Size/Type/Brand:");
    	extraLabel.setBounds(20,180,150,25);
    	dialog.add(extraLabel);
    	
    	JTextField extraField = new JTextField();
    	extraField.setBounds(125,180,125,25);
    	dialog.add(extraField);
    	
    	JButton addBtn = newJButton("Add");
    	addBtn.setBounds(100,250,100,30);
    	dialog.add(addBtn);
    	
    	//Action Listener to adjust extra label based on set category
    	categoryBox.addActionListener(e->{
    		String selected = (String) categoryBox.getSelectedItem();
    		if(selected.equals("Drink")) {
    			extraLabel.setText("Size");
    		}
    		else if(selected.equals("Meal")) {
    			extraLabel.setText("Type");
    		}
    		else {
    			extraLabel.setText("Brand");
    	}});
    	
    	//Action Listener to add item with all variables considered
    	addBtn.addActionListener(e->{
    		try {
    			String name = nameField.getText().trim();
    			double price = Double.parseDouble(priceField.getText().trim());
    			String desc = descField.getText().trim();
    			int cals = Integer.parseInt(calField.getText().trim());
    			String extra = extraField.getText().trim();
    			String cat = (String) categoryBox.getSelectedItem();
    			
    			MenuItem = newItem;
    			
    			//adjust category based on selection of category box
    			switch(cat) {
    			case "Drink":
    				newItem = new Drink(name,price,cals,desc,extra);
    				break;
    			case "Meal":
    				newItem = new Meal(name,price,cals,desc,extra);
    				break;
    			default:
    				newItem = new Snack(name,price,cals,desc,extra);
    				break;
    			
    			
    			menuManager.addItem(newItem);
    			listModel.addElement(new.dislayInfo());
    			dialog.dispose();
    	}catch(Exception ex) {
    		JOptionPane.showMessageDialog(dialog,"Invalid input!");
    	}}});
    	dialog.setVisible(true);
    	}
    	
    //panel for remove button on main
    private void openRemoveDialog() {
    	JDialog dialog = new JDialog(this,"Remove Item",true);
    	dialog.setSize(300,250);
    	dialog.setLayout(null);
    	dialog.setLocationRelaticeTo(this);
    	
    	JLabel = new JLabel("Select Item:");
    	label.setBounds(20,20,100,25);
    	dialog.add(label);
    	
    	//scrollable box of menu item
    	JComboBox<String> dropdown = new JComboBox<>();
    	for(int i=0;i<listModel.size();i++) {
    		dropdown.addItem(listModel.get(i));
    		}
    	dropdown.setBounds(100,20,160,25);
    	dialog.add(dropdown);
    	
    	JButton removeBtn = new JButton("Remove");
    	removeBtn.setBounds(90,60,100,30);
    	dialog.add(removeBtn);
    	
    	//Action Listener to remove selected item when remove button is pressed
    	removeBtn.addActionListener(e->{
    		String selected = (String) dropdown.getSelectedItem();
    		if(selected != null) {
    			listModel.removeElement(selected);
    			menuManager.getAllItem().removeIf(i->i.displayInfo().equals(selected));
    		}
    		dialog.dispose();
    	});
    	dialog.setVisible(true);
    	}
    }