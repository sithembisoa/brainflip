package classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login {
	private String filePath = "config/users.txt";
	
	public Login() {
		
	}
	
	public boolean loginUser(String username, String password) {
		boolean found = false;
		String tmpUser = "", tmpPass="";
		String filePath = "config/users.txt";
		
		try {
			Scanner scanner = new Scanner(new File(filePath));
			scanner.useDelimiter("[,\n]");
			
			while(scanner.hasNext() && !found) {
				tmpUser = scanner.next();
				tmpPass = scanner.next();
				
				if(tmpUser.trim().equals(username.trim()) && tmpPass.equals(password.trim())) {
					found = true;
				}
			}
			scanner.close();
		}catch(IOException e) {
			System.out.print(e.getMessage());
		}
		
		return found;
	}
	
	private boolean foundUser(String username) {
		boolean found = false;
		@SuppressWarnings("unused")
		String tmpUser = "", tmpPass="";
		
		try {
			Scanner scanner = new Scanner(new File(filePath));
			scanner.useDelimiter("[,\n]");
			
			while(scanner.hasNext() && !found) {
				tmpUser = scanner.next();
				tmpPass = scanner.next();
				
				if(tmpUser.trim().equals(username.trim())) {
					found = true;
				}
			}
			scanner.close();
		}catch(IOException e) {
			System.out.print(e.getMessage());
		}
		return found;
	}
	
	public boolean registerUser(String username, String password) {
		if(!foundUser(username)) {
			try {
				FileWriter fout = new FileWriter(filePath, true);
				fout.write(username+","+password+"\n");
				fout.close();
			}catch(IOException e) {
				System.out.print(e.getMessage());
			}
		}else
			return false;
		return true;
	}
}
