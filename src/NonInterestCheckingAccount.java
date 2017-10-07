/*
 * Sean Jeffers 
 * COSC 201
 * October 9, 2015
 * October 9th First project
 */

public class NonInterestCheckingAccount extends Account{
	private String name, type;
	private double balance;
	private int num;
	
	//constructor collecting all of the data
	public NonInterestCheckingAccount(int num,String name, String type, double balance) {
		super(num, name, type, balance);
		
		this.name = name;
		this.type = type;
		this.balance = balance;
		this.num = num;
		
	}
	//returns the account balance
	public double getBalance(){
		return balance;
	}
	// returns the account name
	public String getName(){
		return name;
	}
	//returns the account number
	public int getNum(){
		return num;
	}
	//changes the balance of the account when called by makeWithdrawal and makeDeposit
	public void changeBalance(double change){
		//takes in the deposit or withdrawal and changes the balance accordingly 
		balance += change;
	}
	// prints out info on account
	public String toString(){
		return "Account number: "+num+", Name: " +name+ ", Type: "+ type+", Balance: "+balance+"\n";
	}

}
