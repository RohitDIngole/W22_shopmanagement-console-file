package ProductManagement3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;





public class Product {
	static ArrayList<productinfo3> u1=new ArrayList<>();
	
	public static void product()throws IOException {
		loadtoprogram();
		Scanner r=new Scanner(System.in);
		boolean canikeepthisprogram=true;
		while(canikeepthisprogram==true) {
		System.out.println("****WELCOME TO PRODUCT MANAGEMENT");
		System.out.println("\n");
		System.out.println("1.Entry of Product");
		System.out.println("2.EDIT TO PRODUCT");
		System.out.println("3.DELECTE THE PRODUCT");
		System.out.println("4.SEARCH THE PRODUCT");
		System.out.println("5.QUIT");
		System.out.println("Select the above option");
		int selectoption=r.nextInt();
		
		if(selectoption==5) {
			File file=new File("C:\\Users\\Rohit Ingole\\eclipse-workspace\\mega. java\\ShopManagement3\\src\\ProductManagement3\\pproduct.csv");
			FileWriter fr=new FileWriter(file,true);
			BufferedWriter br=new BufferedWriter(fr);
			for(productinfo3 oo:u1) {
				System.out.println(oo.productName+" "+oo.category+" "+oo.price+" "+oo.quantity+" "+oo.productId+"\n");
				br.write(oo.productName+","+oo.category+","+oo.price+","+oo.quantity+","+oo.productId+"\n");
			}
			br.close();
			fr.close();
			file=null;
			System.out.println("");
			canikeepthisprogram=false;
		}
		else if(selectoption==1) {
			productentry();
			System.out.println("\n");
		}
		else if(selectoption==4) {
			System.out.println("Productname to Search");
			r.nextLine();
			String sp=r.nextLine();
			Searchproduct(sp);
			System.out.println("\n");
			
		}
		else if(selectoption==3) {
			System.out.println("Productname to Delete");
			r.nextLine();
			String dp=r.nextLine();
			DeleteProduct(dp);
			System.out.println("\n");
		}
		else if(selectoption==3) {
			System.out.println("Productname to edit");
			r.nextLine();
			String ep=r.nextLine();
			EditProduct(ep);
			System.out.println("\n");
		}
		
	}
	}
	public static void productentry() {
		Scanner sc=new Scanner(System.in);
		productinfo3 productobject=new productinfo3();
		System.out.println("Enter the name of the product");
   	 productobject.productName=sc.nextLine();
   	 
   	 System.out.println("Enetr the category of the product");
   	 productobject.category=sc.nextLine();
   	
   	 
   	 System.out.println("Enter the price of the product");
   	 productobject.price=sc.nextLine();
   	 
   	 System.out.println("Enter the quality of the product");
   	 productobject.quantity=sc.nextLine();
   	 
   	 System.out.println("Enetr the Product ID ");
   	 productobject.productId=sc.nextLine();
   	 
   	 System.out.println("Name of the product is "+productobject.productName);
   	 
   	  System.out.println("The Category is "+productobject.category);
   	  
   	  System.out.println("The Price of the product is "+productobject.price);
   	  System.out.println("Quality are "+productobject.quantity);
   	  System.out.println("Product ID is "+productobject.productId);
   	  u1.add(productobject);
	}
	public static void Searchproduct(String p) {
		for(productinfo3 pp:u1) {
			if(pp.productName.equalsIgnoreCase(p)) {

	    		 System.out.println("The Category is "+pp.category);
	     	  System.out.println("Name of the product is "+pp.productName); 
	     	  System.out.println("The Price of the product is "+pp.price);
	     	  System.out.println("Quality are "+pp.quantity);
	     	  System.out.println("Product ID is "+pp.productId);
	     	  return;
			}
		}
	}
	public static void DeleteProduct(String delete) {
		Iterator<productinfo3> itr=u1.iterator();
		while(itr.hasNext()) {
         productinfo3 o=itr.next();
         if(o.productName.equalsIgnoreCase(delete)) {
        	 itr.remove();
        	 System.out.println("product "+o.productName+" has benn deleted");
         }
		}
		
	}
	public static void EditProduct(String pp) {
	   	  for(productinfo3 u:u1) {
	   		  if(u.productName.equalsIgnoreCase(pp)) {
	   			 Scanner sc=new Scanner(System.in);
	   			 System.out.println("Edit the product "+u.productName);
	   			 
	   			 System.out.println("Enter the new name of the product");
	   			 u.productName=sc.nextLine();
	   			 
	   			 System.out.println("Enter the product new quantity");
	   			 u.quantity=sc.nextLine();
	   			 
	   			 System.out.println("Enter the product new price");
	   			 u.price=sc.nextLine();
	   			 
	   			 System.out.println("Enter the product new product ID");
	   			 u.productId=sc.nextLine();
	   			 return;
	   		  }
	   	  }
	     }
	public static void loadtoprogram() throws IOException {
		File file=new File("C:\\Users\\Rohit Ingole\\eclipse-workspace\\mega. java\\ShopManagement3\\src\\ProductManagement3\\pproduct.csv");
		FileReader fw=new FileReader(file);
		BufferedReader bw=new BufferedReader(fw);
		String line="";
		while((line=bw.readLine())!=null) {
			productinfo3 uu=new productinfo3();
				String[] dataarray=line.split(",");
				if(dataarray.length>4) {
					uu.productName=dataarray[0];
					uu.category=dataarray[1];
					uu.price=dataarray[2];
					uu.quantity=dataarray[3];
					uu.productId=dataarray[4];
					u1.add(uu);
				
			}
		}
		
		
	}

}
