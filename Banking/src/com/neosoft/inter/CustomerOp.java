package com.neosoft.inter;

public interface CustomerOp {
	void viewAccount(long accountNumber);
	 void allTransaction(long accountNumber);
	 void transferMoney(long accountNumber);
	 void lastFiveTransaction(long accountNumber);
	public void customerOperation(long password);
}
