package Shop_Management;

import java.io.IOException;
import java.util.Scanner;


import ProductManagement3.Product;
import UserManagement.Usermanagement;

public class Application_management {
	public static void main(String[]args) throws IOException {
		Scanner sc=new Scanner(System.in);
		boolean canikeepthisprogram=true;
		while(canikeepthisprogram==true) {
			 System.out.println("****WELCOME TO SHOP MANAGEMENT");
		        System.out.println("\n");
		        
		        System.out.println("****LOGIN****");
		        System.out.println("\n");

		        System.out.println("Enter loginname name");
		        String  loginname = sc.nextLine();

		        System.out.println("Enter password");
		        String password = sc.nextLine();
		        
		        if(!Usermanagement.validateuserandpassword(loginname, password)) {
		        	System.out.println("!!!! LOgin Failed ");
		        	return;
		        }
		        while(canikeepthisprogram==true) {
		        	 System.out.println("Login successful!");
		             System.out.println("1. USER MANAGEMENT");
		             System.out.println("2. PRODUCT MANAGEMENT");
		             System.out.println("3. QUIT");

		             int selectoptionbyuser=sc.nextInt();
		 			if(selectoptionbyuser==1) {
		 				Usermanagement.usermanagement();
		 			}

		 			
		 			else if(selectoptionbyuser==2) {
		 				Product.product();
		 			
		 			}
		 			else if(selectoptionbyuser==3) {
		 				break;
		 			}
		         
		        }
		        
		   
			
		}
	}

}
