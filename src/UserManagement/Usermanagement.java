package UserManagement;

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

public class Usermanagement {
static ArrayList<USER> a1=new ArrayList<>();
	static {try {
		loadtoprogram();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
	public static void usermanagement()throws IOException {
		
		Scanner r=new Scanner(System.in);
		boolean canikeeprunthisprogram=true;
		while(canikeeprunthisprogram==true) { System.out.println("WELCOME TO USER MANAGEMENT");
		System.out.println("\n");
		
		System.out.println("what would you like to do?");
		System.out.println("1.add user");
		System.out.println("2.Edit user");
		System.out.println("3.delete user");
		System.out.println("4.search user");
		System.out.println("5.Quit");
		System.out.println("Select option ");
		System.out.println("Select the option above");
		
		int selectoption=r.nextInt();
		if(selectoption==5) {
			File file=new File("C:\\Users\\Rohit Ingole\\eclipse-workspace\\mega. java\\ShopManagement3\\src\\UserManagement\\user.csv");
			FileWriter fw=new FileWriter(file,false);
			BufferedWriter bw=new BufferedWriter(fw);
			for(USER uuu:a1) { 
				System.out.println(uuu.username+" "+uuu.loginname+" "+uuu.password+" "+uuu.confirmedpassword+" "+uuu.userrole+"\n");
				bw.write(uuu.username+","+uuu.loginname+","+uuu.password+","+uuu.confirmedpassword+","+uuu.userrole+"\n");
			}
			bw.close();
			fw.close();
			file=null;
			System.out.println("Colsed the Program");
			canikeeprunthisprogram=false;
			
		}
		else if(selectoption==1) {
			adduser();
			
		}
		else if(selectoption==4) {
			System.out.println("ENTER USER NAME");
			r.nextLine();
			String sn=r.nextLine();
			SearchUser(sn);
			System.out.println("\n");}
			
			else if(selectoption==3) {
				System.out.println("DELETE USER");
				r.nextLine();
				String  deleteusername=r.nextLine();
				deleteuser(deleteusername);
				
				
			}
		
		
}
		for(int i=0;i<a1.size();i++) {
			
			USER u=a1.get(i);
			System.out.println(u.userrole);
			System.out.println(u.loginname);
			System.out.println(u.password);
			System.out.println(u.confirmedpassword);
			System.out.println(u.userrole);}
		for(USER u:a1) {
			System.out.println(u.userrole);
			System.out.println(u.loginname);
			System.out.println(u.password);
			System.out.println(u.confirmedpassword);
		}
		}
		
		public static void adduser() {
			Scanner r=new Scanner(System.in);
			USER userobject=new USER();
			
			System.out.println("ENTER USERNAME");
			userobject.username=r.nextLine();
			
			System.out.println("ENTER LOGIN NAME");
			userobject.loginname=r.nextLine();
			
			System.out.println("ENTER PASSWORD");
			userobject.password=r.nextLine();
			
			System.out.println("ENTER CONFIRMED PASSWORD");
			userobject.confirmedpassword=r.nextLine();
			
			System.out.println("ENTER USER ROLE");
			userobject.userrole=r.nextLine();
			a1.add(userobject);
		}
		
		public static void SearchUser(String usernam) {
			for(USER user:a1) {//for each//
				if(user.username.equalsIgnoreCase(usernam)) {
					System.out.println("username"+user.username);
				    System.out.println("login name "+user.loginname);
				    System.out.println("Password is "+user.password);
				    System.out.println("Confirmed Password "+user.confirmedpassword);
				    System.out.println("User Role "+user.userrole);
				    return;
			}
				}
		
			
}
			
		public static void deleteuser(String username) {
			Iterator<USER>useriterator=a1.iterator();
			while(useriterator.hasNext()) 
			{
				USER user=useriterator.next();
				if(user.username.equalsIgnoreCase(username)) {
					useriterator.remove();
					System.out.println("User name "+user.username+"has been delete ");
				}
			
		
	}	
		}
		public static void loadtoprogram() throws IOException {
			File file=new File("C:\\Users\\Rohit Ingole\\eclipse-workspace\\mega. java\\ShopManagement3\\src\\UserManagement\\user.csv");
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String line="";
			while((line=br.readLine())!=null){
				USER u=new USER();
				String[] dataarray=line.split(",");
				if(dataarray.length>3) {
					u.username=dataarray[0];
					u.loginname=dataarray[1];
					u.password=dataarray[2];
					u.confirmedpassword=dataarray[3];
					u.userrole=dataarray[4];
					a1.add(u);
				}
				
				
			}
			br.close();
			fr.close();
			file=null;
		}
		public static boolean validateuserandpassword(String loginname,String password) {
			Iterator<USER> itr=a1.iterator();
			while(itr.hasNext()) {
				USER u=itr.next();
				if(u.loginname.equalsIgnoreCase(loginname)&&u.password.equalsIgnoreCase(password)) {
					return true;
				}
				
			}
			return false;
		}
}
