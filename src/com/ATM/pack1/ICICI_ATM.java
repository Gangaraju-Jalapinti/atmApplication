package com.ATM.pack1;

import java.util.Scanner;

public class ICICI_ATM extends Atm_DataBase implements ATM{
	public ICICI_ATM(long accountNumber, int passWord,String dataBaseName) 
	{
		super(accountNumber,passWord,dataBaseName);

	}
								// ATM operations
//_____________________________________________________________________________________________________________________________________
	
						//--------1. deposit method ---------
	@Override
	public void depositAmount()
	{
		System.out.print("Enter Deposit Ammount : ");
		Scanner sc = new Scanner(System.in);
		double amount= sc.nextDouble();
		// send deposit amount to datadase
		double totalAmount = getBalance()+amount;
		setBalance(totalAmount);
		changeBalanceTo(totalAmount);
		System.out.println(amount+" is deposited sucussfully");
		System.out.println("your balance : "+totalAmount);

	}
//______________________________________________________________________________________________________________________________________
	                   
						// ------2.withdrow method ----------
	
	@Override
	public void withdrowAmount() throws InSufficientBalanceException
	{
		System.out.print("Enter withdrow Ammount : ");
		Scanner sc = new Scanner(System.in);
		double amount= sc.nextDouble();
		//check amount wase there are not

		if(amount>getBalance()) 
		{
		
				try {
					throw new InSufficientBalanceException("Insuficiant ammount");
				}
				finally 
				{
					System.out.println("---------Thanks for using Sbi Atm-------------");	
				}
		}
		double totalAmount = getBalance()-amount;
		// set balence in database
		setBalance(totalAmount);
		changeBalanceTo(totalAmount);
		System.out.println(amount+" is withdrown sucussfully");
		System.out.println("your balance : "+getBalance());
	}
//_______________________________________________________________________________________________________________________________________________

				//--------3. check balance method ---------------
	@Override
	public void checkBalance()
	{
		//take balance from database
		double balance = getBalance();
		System.out.println("Your Balance is :"+ balance);
	}

//_______________________________________________________________________________________________________________________________________________________________________


}
