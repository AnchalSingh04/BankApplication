package com.neosoft.admin;

import java.util.ArrayList;
import java.util.Scanner;

import com.neosoft.pojo.CommonMethods;
import com.neosoft.pojo.CustomerPojo;
import com.neosoft.pojo.TransactionPojo;
class Login implements CommonMethods{
	Scanner sc=new Scanner(System.in);
	AdminOperation Imp2=new AdminOperation();
	Transaction T1=new Transaction();
	
	@Override
	public void adminLogin() {
		System.out.println("Enter the username");
		String username= sc.nextLine();
		System.out.println("Enter the Password");
		String password= sc.nextLine();
		
		
		if(username.equals(CommonMethods.username) && password.equals(CommonMethods.password)){
			System.out.println("You have login Successfully");
			Imp2.selectAdminOperation();
		}
		else {
			System.out.println("Enter the correct input");
		}
		
	}

	@Override
	public void customerLogin() {
		System.out.println("Enter the username");
		String username= sc.next();
		System.out.println("Enter the Password (Disclamer-Your AccountNumber is your Password)");
		 long password=sc.nextLong();
//	     boolean found= false;
			for(CustomerPojo c:MainBank.info ) {
				System.out.println(c.getName());

				if( c.getAccNo()==password && c.getName().equals(username)) {
//					found=true;
					System.out.println(c.getAccNo());
						System.out.println("You have login Successfully");
						T1.customerOperation(password);
					}
					else {
						System.out.println("Enter the correct input");
					}
	}}
	
}
public class MainBank {
	
	public static ArrayList<CustomerPojo> info= new ArrayList<>();
	public static ArrayList<TransactionPojo> Transaction= new ArrayList<>();
	public static void main(String[] args) {
		try {
			int ch=0;
			Login Imp1=new Login();
			
			Scanner sc=new Scanner(System.in);
			do {
			System.out.println("-----------Welcome To Neosoft Bank-----------");
			System.out.println(" ********Menu**********");
			System.out.println("1. Login as Admin");
			System.out.println("2. Login as Customer");
			System.out.println("3. Exit");
			System.out.println("Select the service");
			ch=Integer.parseInt(sc.nextLine());	
			switch(ch) {
			case 1:
				Imp1.adminLogin();
				break;
			case 2:
				Imp1.customerLogin();
				break;
			case 3:
				
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
			}while(ch!=3);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}}


