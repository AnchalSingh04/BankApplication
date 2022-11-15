package com.neosoft.admin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import com.neosoft.inter.AdminOp;
import com.neosoft.pojo.CustomerPojo;
import com.neosoft.pojo.TransactionPojo;

public class AdminOperation implements AdminOp {
    CustomerPojo customer;
//    ArrayList<CustomerPojo> info= new ArrayList<>();
//    ArrayList<Integer> Transaction= new ArrayList<>();
//    		
	Scanner sc=new Scanner(System.in);
	long amount; 
	
	
//	method of open account
	
	public void accountopen() {
		
//        info.add(new CustomerPojo(Name,AccountNo,Balance));
       
        System.out.println("-----Registering An account-----");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		String name = sc.nextLine();
		System.out.println("Enter Initial Deposit");
		double balance = sc.nextDouble();
//        System.out.println("Enter your name");
//		String name=sc.nextLine();
////		System.out.println("Enter your account Number");
////		long accountNo=sc.nextLong();
//		System.out.println("Your Account balance ");
//		double  balance=sc.nextDouble();
		System.out.println("Enter your Age");
		int age=sc.nextInt();
		CustomerPojo s1=new CustomerPojo(name,CustomerPojo.i, balance, age);
		 boolean addcheck=MainBank.info.add(s1);
		System.out.println("your account number is"  +  s1.getAccNo());
		
		
		
		
		
        if(addcheck){
        	System.out.println("Successfully Account Created");
        	
        	
        }
        
	}
	
	
	public void deposit() {
		 double amt;
//		 boolean found = false;
		 
		 
//		    CustomerPojo s3=new CustomerPojo();
       System.out.println("Enter the account you want to deposit: ");  
//       CustomerPojo c;
//       accountNumber=c.getAccNo();
//       accountNumber = sc.nextLong(); 
       long accountNumber=sc.nextLong();
        boolean found=false;
		for(CustomerPojo c:MainBank.info ) {
			if(c.getAccNo()==accountNumber) {
				found=true;
				ListIterator<CustomerPojo> itr1 = MainBank.info.listIterator();
				while(itr1.hasNext()) {
					CustomerPojo c1 = itr1.next();
					if(c.getAccNo() == accountNumber) {
						
						System.out.println("Enter the amount to deposit");
						amt = sc.nextLong();
						
						int value = MainBank.info.indexOf(c);
						
						double total = c.getBalance()+amt;
						
						System.out.println("total amount =" + total);
						c.setBalance(total);
						System.out.println("c value = " + c);
						MainBank.info.set(value,c);
						TransactionPojo transaction = new TransactionPojo(accountNumber,"deposit",amt, c1.getBalance());
						MainBank.Transaction.add(transaction);
						
						break;
					}
				}
				
			}else {
//				Account notfoundExcption
				System.out.println("No account is present on this account number");
			}
				
				

			}
//	        s3.setBalance(amt+s3.getBalance());
	       
	        
	        
		
	}

	
    public void withdraw(){
    	 double amt;
//		 boolean found = false;
		 
		 
//		    CustomerPojo s3=new CustomerPojo();
       System.out.println("Enter the account you want to Withdraw: ");  
//       CustomerPojo c;
//       accountNumber=c.getAccNo();
//       accountNumber = sc.nextLong(); 
       long accountNumber=sc.nextLong();
		boolean found=false;
		for(CustomerPojo c:MainBank.info ) {
			if(c.getAccNo()==accountNumber) {
				found=true;
					ListIterator<CustomerPojo> itr1 = MainBank.info.listIterator();
					while(itr1.hasNext()) {
						CustomerPojo c1 = itr1.next();
						if(c1.getAccNo() == accountNumber) {
							
							System.out.println("Enter the amount to Withdraw");
							amt = sc.nextDouble();
							
							int value = MainBank.info.indexOf(c);
							
							Double total = c1.getBalance()-amt;
							
							System.out.println("total amount =" + total);
							c.setBalance(total);
							System.out.println("c value = " + c1);
							MainBank.info.set(value,c1);
							TransactionPojo transaction = new TransactionPojo(accountNumber,"deposit",amt, c1.getBalance());
							MainBank.Transaction.add(transaction);
//							break;
						}else {
//					Account notfoundExcption
					System.out.println("No account is present on this account number");
				}
					}
					
				}
					
        

			

				
			}
		}        
		
	
    	
    
	
	public void deleteAccount() {
	   System.out.println("Enter Account Number");
	  int i=sc.nextInt();
	   for(i=0;i<MainBank.info.size();i++) {
		   if(CustomerPojo.i==i){
			   MainBank.info.remove(customer);		
			   
		   }
		   else {
			   System.out.println("Account not found");
		   }
	   }
		
		
	}
	public void viewAll() {
		for(CustomerPojo s2:MainBank.info) {
			System.out.println(s2);
		}
		
		
	}
	public void logout() {
		System.out.println("You hav successfully Logout");
		
		MainBank.main(null);
		
	}



	public void selectAdminOperation() {
    	int ch=0;
        AdminOperation Imp=new AdminOperation();
        do {
		System.out.println("************Admin Operation************");	
		System.out.println("1. Open Account for new Customer");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Delete an Account");
		System.out.println("5. View all the customers of the bank");
		System.out.println("6. Logout");
		System.out.println("Select the service");
		ch=Integer.parseInt(sc.nextLine());		
		switch(ch) {
		case 1:
			Imp.accountopen();
			break;
		case 2:
			Imp.deposit();
			break;
		case 3:
			Imp.withdraw();
			break;
		case 4:
			Imp.deleteAccount();
			break;
		case 5:
			Imp.viewAll();
			break;
		case 6:
			Imp.logout();
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
	}while(ch!=6);
}

}
      

