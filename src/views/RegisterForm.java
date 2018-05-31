package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import classes.Login;


public class RegisterForm  extends JFrame implements ActionListener{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame = new JFrame("BrainFlip - Login");
     
	 JLabel l1, l2, l3, l4;
	 JTextField tf1;
	 JButton btn1, btn2;
	 JPasswordField p1, p2;
	 public RegisterForm() {
		  l1 = new JLabel("Register Form");
		  l1.setFont(new Font("Serif", Font.BOLD, 20));
		  l2 = new JLabel("Username");
		  l3 = new JLabel("Password");
		  l4 = new JLabel("Retype-Password");
		  tf1 = new JTextField();
		  p1 = new JPasswordField();
		  p2 = new JPasswordField();
		  btn1 = new JButton("Register");
		  
		  l1.setBounds(100, 30, 200, 30);
		  l2.setBounds(80, 70, 200, 30);
		  l3.setBounds(80, 110, 200, 30);
		  l4.setBounds(40, 150, 200, 30);
		  tf1.setBounds(150, 70, 200, 30);
		  p1.setBounds(150, 110, 200, 30);
		  p2.setBounds(150, 150, 200, 30);
		  btn1.setBounds(150, 200, 100, 30);
		  btn1.addActionListener(this); 
		  frame.add(l1);
		  frame.add(l2);
		  frame.add(tf1);
		  frame.add(l3);
		  frame.add(l4);
		  frame.add(p1);
		  frame.add(p2);
		  frame.add(btn1);
		  
		  frame.setSize(400, 300);
		  frame.setLayout(null);
		  frame.setLocationRelativeTo(null);
		  frame.setVisible(true);
	 }
	 
	public void actionPerformed(ActionEvent ae) {
		Login login = new Login();
		String uname = tf1.getText();
		@SuppressWarnings("deprecation")
		String pass = p1.getText();
		@SuppressWarnings("deprecation")
		String c_pass = p2.getText();
		
		if(!pass.trim().equals(c_pass.trim())) {
			JOptionPane.showMessageDialog(this,"Passwords don't match",
				      "Error",JOptionPane.ERROR_MESSAGE); 
		}else {
			if(login.registerUser(uname, pass)) {
				@SuppressWarnings("unused")
				LoginForm form = new LoginForm();
				frame.dispose();
			}else {
				JOptionPane.showMessageDialog(this,"Username already exists",
					      "Error",JOptionPane.ERROR_MESSAGE); 
			}
		}
		
	}
}