package brainflip;

import java.io.File;

public class RenameTest 
{
    public static void main(String[] args)
    {	
    	
		File oldfile =new File("config/file.txt");
		File newfile =new File("config/newfile.txt");
		
		if(oldfile.renameTo(newfile)){
			System.out.println("Rename succesful");
		}else{
			System.out.println("Rename failed");
		}
    	
    }
}
