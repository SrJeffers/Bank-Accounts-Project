/*
 * Sean Jeffers 
 * COSC 201
 * October 9, 2015
 * October 9th First project
 */

import java.text.DecimalFormat;

public class PlatinumCheckingAccount extends InterestCheckingAccount{
	private String name, type;
	private double balance;
	private double interest;
	private int num;
	
	//constructor collecting all of the data
	public PlatinumCheckingAccount(int num, String name, String type, double balance, double interest) {
		super(num, name, type, balance, interest);
		
		this.name = name;
		this.type = type;
		this.balance = balance;
		this.interest= interest;
		this.num = num;
	}
	//returns the account balance
	public double getBalance(){
		return balance;
	}
	//returns the account name
	public String getName(){
		return name;
	}
	// returns the account number
	public int getNum(){
		return num;
	}
	//changes the balance of the account when called by makeWithdrawal and makeDeposit
	public void changeBalance(double change){
		balance += change;
	}
	//calculates interest for accounts
	public void addInterest() {
		this.balance += (.01*interest*2)* balance;
	}
	// prints out info on account
	public String toString(){
		DecimalFormat df = new DecimalFormat("#.##");
		//above line found at http://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java
		return "Account number: "+num+", Name: " +name+ ", Type: "+ type+", Balance: "+df.format(balance)+
				", Interest Rate: "+df.format(interest) +"\n";
	}

}