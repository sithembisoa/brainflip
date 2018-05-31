package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import classes.Login;


public class LoginForm  extends JFrame implements ActionListener{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame = new JFrame("BrainFlip - Login");
     
	 JLabel l1, l2, l3;
	 JTextField tf1;
	 JButton btn1, btn2;
	 JPasswordField p1;
	 public LoginForm() {
		  l1 = new JLabel("Login Form");
		  l1.setFont(new Font("Serif", Font.BOLD, 20));
		  l2 = new JLabel("Username");
		  l3 = new JLabel("Password");
		  tf1 = new JTextField();
		  p1 = new JPasswordField();
		  btn1 = new JButton("Login");
		  btn2 = new JButton("Register");
		  
		  l1.setBounds(100, 30, 200, 30);
		  l2.setBounds(80, 70, 200, 30);
		  l3.setBounds(80, 110, 200, 30);
		  tf1.setBounds(150, 70, 200, 30);
		  p1.setBounds(150, 110, 200, 30);
		  btn1.setBounds(150, 160, 100, 30);
		  btn1.addActionListener(this); 
		  btn2.setBounds(260, 160, 90, 30);
		  btn2.addActionListener(this); 
		  frame.add(l1);
		  frame.add(l2);
		  frame.add(tf1);
		  frame.add(l3);
		  frame.add(p1);
		  frame.add(btn1);
		  frame.add(btn2);
		  
		  frame.setSize(400, 300);
		  frame.setLayout(null);
		  frame.setLocationRelativeTo(null);
		  frame.setVisible(true);
	 }
	 
	 public void actionPerformed(ActionEvent ae) {
		 String uname = tf1.getText();
		 @SuppressWarnings("deprecation")
		 String pass = p1.getText();
		 Login login = new Login();
		   
		 if(ae.getActionCommand().equals("Login")){
			   if(login.loginUser(uname, pass)) {
				   BrainflipGame instance = new BrainflipGame(uname);
				   instance.newGame();
				   frame.dispose();
			    }
			    else {
			      JOptionPane.showMessageDialog(this,"Incorrect login or password",
			      "Error",JOptionPane.ERROR_MESSAGE); 
			    }
		 }
		 if(ae.getActionCommand().equals("Register")){
			 @SuppressWarnings("unused")
			 RegisterForm reg = new RegisterForm();
		 }
	  }
	
}
