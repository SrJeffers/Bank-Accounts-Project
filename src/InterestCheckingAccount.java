/*
 * Sean Jeffers 
 * COSC 201
 * October 9, 2015
 * October 9th First project
 */

import java.text.DecimalFormat;



public class InterestCheckingAccount extends Account implements InterestBearingAccount{
	private String name, type;
	private double balance;
	private double interest;
	int num;
	
	//constructor collecting all of the data
	public InterestCheckingAccount(int num, String name, String type, double balance, double interest){
		super(num, name, type, balance);
		this.num = num;
		this.name = name;
		this.type = type;
		this.balance = balance;
		this.interest = interest;
		
	}
	
	//returns balance
	public double getBalance(){
		return balance;
	}
	//returns account number
	public int getNum(){
		return num;
	}
	public void addInterest() {
		//calculates interest after entry.addInterest is called
		this.balance += balance *(interest*.01);
	}
	
	//changes the balance of the account when called by makeWithdrawal and makeDeposit
	public void changeBalance(double change){
		balance += change;
		
	}
	
	// prints out info on account
	public String toString(){
		DecimalFormat df = new DecimalFormat("#.##");
		return "Account number: "+ num+", Name: " +name+ ", Type: "+ type+", Balance: "+df.format(balance)+
				", Interest Rate: "+df.format(interest) +"\n";
	}

}
