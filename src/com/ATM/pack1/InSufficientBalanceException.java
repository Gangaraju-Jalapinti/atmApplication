package com.ATM.pack1;

public class InSufficientBalanceException extends Exception
{
	InSufficientBalanceException()
	{
		super("Low Balance...");
	}
	InSufficientBalanceException(String message)
	{
		super(message);
	}

}
