import javax.swing.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    
	private JTextField userField;
	private JPasswordField passField;
	
	// Login
	
	private final String VALID_USER = "admin";
	private final String VALID_PASS = "pass123";
	
	public static void main(String[] args) {
		
		new LoginFrame();
		
	}
    
	public LoginFrame() {
		
		setTitle("Login - Rollins Cafe");
		setSize(360,230);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Please Log In");
		title.setBounds(120, 10, 200, 25);
		add(title);
		
		JLabel userLabel = new JLabel("Username:");
		userLabel.setBounds(40, 50, 80, 25);
		add(userLabel);
		
		userField = new JTextField();
        userField.setBounds(130, 50, 160, 25);
        add(userField);
        
        JLabel passLabel = new JLabel("Password");
		passLabel.setBounds(40,90, 80, 25);
		add(passLabel);
		
		passField = new JPasswordField();
		passField.setBounds(130, 90, 160, 25);
		add(passField);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(120, 130, 100, 30);
		add(loginBtn);
		
		// Button to check for login
		
		loginBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				tryLogin();
				
			}
		});
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	private void tryLogin() {
		
		String user = userField.getText().trim();
		String pass = String.valueOf(passField.getPassword());
		
		if (user.isEmpty() || pass.isEmpty()) {
			
			JOptionPane.showMessageDialog(this, "Enter both fields.");
			return;
			
		}
	
		if (user.equals(VALID_USER) && pass.equals(VALID_PASS)) {
			
			JOptionPane.showMessageDialog(this, "Welcome to RollinsCafe!");
			
			// Hide login and open the menu
			
			setVisible(false);
			MenuFrame menu = new MenuFrame(this);
			menu.setVisible(true);
		
		} else {
			
			JOptionPane.showMessageDialog(this, "Invalid login. Try admin / pass123.");
	
		}
    }
