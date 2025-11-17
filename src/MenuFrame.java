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
        
    }

    private void showItems(List<MenuItem> items) {
    	
        listModel.clear();
        for (MenuItem mi : items) {
        	
            listModel.addElement(mi.displayInfo());
            
        }
    }
