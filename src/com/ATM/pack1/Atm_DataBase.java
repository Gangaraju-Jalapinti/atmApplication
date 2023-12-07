package com.ATM.pack1;

import java.sql.*;

public class Atm_DataBase {
	private long accountNumber;
	private int passWord;
	private double balance;
	protected String dataBaseName;
	private Statement st;
//____________________CONSTRUCTOR_________________________
	public Atm_DataBase(long accountNumber, int passWord, String dataBaseName) {
		super();
		this.accountNumber = accountNumber;
		this.passWord = passWord;
	
		this.st = st;
		this.dataBaseName = dataBaseName;
	}


	
	

//_______________GETERS AND SETTERS________________________________________
    
	public void setBalance(double balance) 
	{
		this.balance = balance;
	}
	public double getBalance() 
	{

		return balance;
	}
	
//____________________________ACCOUNT VAIDATION METHOD ___________________________________________
	
	public  boolean validateAccount()
	{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/"+dataBaseName;
		String userName = "root";
		String pswd = "Raju@9390";
		
		try {
			// Step1 : Register the Driver
			Class.forName(driver);

			// Step2 : getConnection
			Connection con = DriverManager.getConnection(url, userName, pswd);

			// step3 : creatStatement

			 this.st = con.createStatement();
	
			ResultSet s = st.executeQuery("select * from accholders where accountNumber = "+accountNumber+" and password="+passWord+";");

			if (s.next()) 
			{

				this.balance = s.getDouble("balance");
				return true;
			}
			else return false;
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}

		return false;
	}
	

//_________________________________________________________________________________________________________________________
	public boolean changeBalanceTo(double totalAmount) {
		try {
			 st.executeUpdate("update accholders set balance ="+ totalAmount +"where accountNumber = "+accountNumber+" and password="+passWord+";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}





}

