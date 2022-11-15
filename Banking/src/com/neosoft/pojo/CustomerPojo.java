package com.neosoft.pojo;

import java.math.BigDecimal;

public class CustomerPojo {
	private String name;
	private long accNo;
	private double balance;
	private int age; 
	public static int i=1000;
	
	
		
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
//	@Override
//	public String toString() {
//		return "CustomerPojo [name=" + name + ", accNo=" + accNo + ", balance=" + balance + ", age=" + age + "]";
//	}
//	public CustomerPojo(String name, long accNo, BigDecimal balance, int age) {
//		super();
//		this.name = name;
//		this.accNo = accNo;
//		this.balance = balance;
//		this.age = age;
//		this.i=i;
//	}
	public CustomerPojo(String name, long accNo,double balance, int age ){
		super();
		this.name = name;
        this.accNo = accNo;
		this.balance = balance;
		this.age = age;
		i++;
		
	}
@Override
	public String toString() {
		return "CustomerPojo [name=" + name + ", accNo=" +accNo + ", balance=" + balance + ", age=" + age + "]";
	}
	//	public static int getI() {
//		return i;
//		
//	}
//	public static void setI(int i) {
//		CustomerPojo.i = i;
//		
//	}
	
	public CustomerPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
