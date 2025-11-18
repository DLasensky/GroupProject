import javax.swing.*;
import java.awt.event.*;
import java.util.List;

/// cafe window with a simple list and filters

public class MenuFrame extends JFrame {

    private LoginFrame loginRef;
    private MenuManager menuManager;
    private DefaultListModel<String> listModel;
    private JList<String> list;

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

        listModel = new DefaultListModel<String>();
        list = new JList<String>(listModel);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setBounds(30, 50, 430, 200);
        add(scroll);

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


        Java restaurant menu management system tutorial






        
    }

    private void showItems(List<MenuItem> items) {
    	
        listModel.clear();
        for (MenuItem mi : items) {
        	
            listModel.addElement(mi.displayInfo());
            
        }
    }
