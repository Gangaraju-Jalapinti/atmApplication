package com.ATM.pack1;

public interface ATM {
	public void depositAmount();
	public void withdrowAmount() throws InSufficientBalanceException ;
	public void checkBalance();
	public boolean validateAccount();
}