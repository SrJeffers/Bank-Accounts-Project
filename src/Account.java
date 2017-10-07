/*
 * Sean Jeffers 
 * COSC 201
 * October 9, 2015
 * October 9th First project
 */

public abstract class Account {
	private String name, type;
	private double balance;
	private int num;
	
	//constructor collecting all of the data
	public Account(int num, String name, String type, double balance){
		this.name = name;
		this.type = type;
		this.balance = balance;
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
	//returns the account number
	public int getNum(){
		return num;
	}
	//changes the balance of the account when called by makeWithdrawal and makeDeposit
	public void changeBalance(double change){
		balance += change;
	}
	// prints out info on account
	public String toString(){
		return "Account number: "+num+", Name: " +name+ ", Type: "+ type+", Balance: "+balance+"\n";
	}
	
	// empty method used for add interest in the other accounts
	public void addInterest(){
	}
	// returns 0 for the compareTo method in bank
	public int compareTo(Account check) {
		return 0;
	}


	

}
