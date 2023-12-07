package com.ATM.pack1;

import java.sql.SQLException;
import java.util.Scanner;

public class Display {

	static Scanner sc;
	ATM atm;
	static int bankType;
	
private static void Display_Atms()
{
	Display obj = new Display();
	sc = new Scanner(System.in);
	int count = 0;
	while (true) {
	    System.out.println("\n1.SBI ATM." + 
						   "\n2.HDFC ATM" +
						   "\n3.ICICI ATM");
		
		System.out.println("Enter Your choice: ");
		bankType = sc.nextInt();
		
		if ((bankType >= 1 && bankType <= 3) && count < 3) 
			{
				obj.verifyCustomer();
			}
		if (count == 3) 
			{
				System.out.println("Butter Luck Next Time");
				break;
			}
		System.out.println("invalid option..");
		count++;
	}
}

//_______________________________________________________________________________________________________________________
	public static void main(String[] args) {

		Display_Atms();

	}

//______________________________________________________________________________________________________________________________
	public void verifyCustomer() {

		// System.out.println("____Wellcome To State Bank Of India________________\n");

		System.out.print("Please Enter Account Number : ");
		long accountNumber = sc.nextLong();

		System.out.print("Enter Password :");
		int passWord = sc.nextInt();
		switch (bankType) {
		case 1:
			atm = new SBI_ATM(accountNumber, passWord, "sbi");
			break;
		case 2:
			atm = new HDFC_ATM(accountNumber, passWord, "hdfc");
			break;
		case 3:
			atm = new ICICI_ATM(accountNumber, passWord, "icici");
		}
		boolean flag = atm.validateAccount();
		display_Options(flag);

	}

	// ___________________________________________________________________________________________________________________________
	public void display_Options(boolean flag) {
		Scanner scanner = new Scanner(System.in);

		if (flag) {

			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				atm.depositAmount();
				reEnter();
				break;
			case 2:
				try 
				{
				atm.withdrowAmount();
				}catch(InSufficientBalanceException e)
				{
					reEnter();
				}
				
				break;
			case 3:
				atm.checkBalance();
				reEnter();
				break;
			case 4:
				System.out.println("Thank you for using the ATM !");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				System.out.println("__________________________________________________________________");
				display_Options(true);
				break;
			}
		} else {
			System.out.println("Invalid Password or acoountNumber");
			System.out.println("Do want to re Enter agein press 1 other wise press any other to exit");
			if (scanner.nextInt() == 1)
				verifyCustomer();
			System.out.println("---------Thanks for using Sbi Atm-------------");
			System.exit(0);
		}
	}

	// __________________________________________________________________________________________________________________________
	public void reEnter() {
		System.out.println("_______________________________________________________\n");
		System.out.println("Dou want to exit ? press 1. ");
		System.out.println("Renter press any number ");

		if (sc.nextInt() == 1) {
			System.out.println("---------Thanks for using Sbi Atm-------------");
			System.exit(0);
		}
		verifyCustomer();
	}

}
