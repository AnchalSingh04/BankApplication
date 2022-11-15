package com.neosoft.admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Scanner;

import com.neosoft.inter.CustomerOp;
import com.neosoft.pojo.CustomerPojo;
import com.neosoft.pojo.TransactionPojo;

public class Transaction implements CustomerOp
{
	CustomerPojo c;
	Scanner sc = new Scanner(System.in);
	@Override
	public void viewAccount(long accountNumber) {
		

	 
		 
			for(CustomerPojo c:MainBank.info ) {
				if(c.getAccNo()==accountNumber) {
					System.out.println("_______Your Account Details_________");
					System.out.println("Account Number" +c.getAccNo());
					System.out.println("Name" +c.getName()); 
					System.out.println("Age" +c.getAge());
					System.out.println("Balance" +c.getBalance());
				}
				}
//		
	}

	@Override
	public void allTransaction(long accountNumber) {
		for(TransactionPojo s2:MainBank.Transaction) {
			System.out.println(MainBank.Transaction.size());
			System.out.println(s2);
		}
		
	}

	@Override
	public void transferMoney(long accountNumber) {
		double amt = 0;
		boolean found=false;
		System.out.println("Enter the beneficary account number");
		long acctNumber=sc.nextLong();
		
		for(CustomerPojo c:MainBank.info ) {
			if(c.getAccNo()==acctNumber) {
				found=true;
				ListIterator<CustomerPojo> itr1 =MainBank.info.listIterator();
				while(itr1.hasNext()) {
					
					CustomerPojo c1 = itr1.next();
					if(c1.getAccNo() == acctNumber) {
						
						System.out.println("Enter the amount to deposit");
						amt = sc.nextDouble();
						
						int value = MainBank.info.indexOf(c1);
						
						Double total =c1.getBalance()+amt;
						
//						System.out.println("total amount =" + total);
						c1.setBalance(total);
						MainBank.info.set(value,c1);
						System.out.println("c value = " + c1);
						TransactionPojo transaction = new TransactionPojo(accountNumber,"deposit",amt, c1.getBalance());
						MainBank.Transaction.add(transaction);
						System.out.println(c1.getBalance());
					
//						for the beneficiary account
						
						for(CustomerPojo k:MainBank.info ) {
							if(c.getAccNo()==accountNumber) {
							ListIterator<CustomerPojo> itr2 =MainBank.info.listIterator();
								while(itr2.hasNext()) {
									
									CustomerPojo k1 = itr2.next();
									if(k1.getAccNo() == accountNumber ) {
										
										
										int value1 = MainBank.info.indexOf(k1);
										
										Double tl =k1.getBalance()-amt;
										
										System.out.println("total amount =" + tl);
										c.setBalance(tl);
										MainBank.info.set(value1,k1);
										TransactionPojo transaction1 = new TransactionPojo(accountNumber,"deposit",amt, k.getBalance());
										MainBank.Transaction.add(transaction1);
										System.out.println("Rec" +k.getBalance());
										
		                   break;}
		                   
						
				}
								
							
							}
							}}}}}}
		
	

	@Override
	public void lastFiveTransaction(long accountNumber) {
		List<TransactionPojo> L1=new ArrayList<>();
		for(TransactionPojo trans:MainBank.Transaction) {
			if(trans.getAccNo()==accountNumber) {
				L1.add(trans);
				
			}
		}
		if(L1.size()>5) {
			Collections.reverse(L1);
			L1.subList(0,5);
			ListIterator<TransactionPojo> itr3 =MainBank.Transaction.listIterator();
			while(itr3.hasNext()) {
				TransactionPojo Transaction=(TransactionPojo) itr3.next();	
			    System.out.println(Transaction);
				}
			
		}
		else {
			Collections.reverse(L1);
			ListIterator<TransactionPojo> itr3 =MainBank.Transaction.listIterator();
			while(itr3.hasNext()) {
				TransactionPojo Transaction=(TransactionPojo) itr3.next();	
			    System.out.println(Transaction);
				}
			
		}
	}

	@Override
	public void customerOperation(long password) {
		int ch=0;
		long accountNumber=password;
        Transaction Imp=new Transaction();
        do {
		System.out.println("************Admin Operation************");	
		System.out.println("1. View Your Account");
		System.out.println("2. View All Transaction");
		System.out.println("3. Transfer Money");
		System.out.println("4. View last 5 transaction");
		System.out.println("Select the service");
		
		ch=Integer.parseInt(sc.nextLine());		
		switch(ch) {
		case 1:
			Imp.viewAccount(password);
			break;
		case 2:
			Imp.allTransaction(accountNumber);
			break;
		case 3:
			Imp.transferMoney(accountNumber);
			break;
		case 4:
			Imp.lastFiveTransaction(accountNumber);
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
	}while(ch!=6);
}

		
	}

	

