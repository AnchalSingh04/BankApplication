package com.neosoft.pojo;

//import java.time.LocalDateTime;
import java.util.Date;

public class TransactionPojo {
	
		
		private long accNo;
		private Date d= new Date();
		private String type;
		private double amt;
		private double  Balance;
		public long getAccNo() {
			return accNo;
		}
		public void setAccNo(long accNo) {
			this.accNo = accNo;
		}
		public Date getD() {
			return d;
		}
		public void setD(Date d) {
			this.d = d;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public double getAmt() {
			return amt;
		}
		public void setAmt(double amt) {
			this.amt = amt;
		}
		public double getBalance() {
			return Balance;
		}
		public void setBalance(double balance) {
			Balance = balance;
		}
		@Override
		public String toString() {
			return "TransactionPojo [accNo=" + accNo + ", d=" + d + ", type=" + type + ", amt=" + amt + ", Balance="
					+ Balance + "]";
		}
		public TransactionPojo(long accNo,String type, double amt, double balance) {
			super();
			this.accNo = accNo;
			this.type = type;
			this.amt = amt;
			Balance = balance;
		}
		public TransactionPojo() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}
		
		
		
		
		