/*
 * Sean Jeffers 
 * COSC 201
 * October 9, 2015
 * October 9th First project
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	Scanner input = new Scanner(System.in);
	private ArrayList <Account> accts = new ArrayList<Account>();
	private String name;
	private int type;
	private double deposit, balance;
	private float interest;

	public double totalAssets(){
		//calculating the total assets of the bank using a for loop that finds the ballance for each 
		//account and adds to the total
		double assets = 0;
		for(int i = 0; i < accts.size();i++){
			assets += accts.get(i).getBalance();
		}
		return assets;
	}
	
	public void addAccount(Account acct){
		//adding the accounts to the array
		accts.add(acct);
	}
	
	public void openAccount(){
		//asks for user input to create an account
		System.out.println("***Open Account***");
		System.out.println("Enter name: ");
		boolean error = true;
		String x;
		name = input.nextLine();
		
		System.out.println("Enter account type:(0 for checking, 1 for Interest checking, and 2 for Platinum Interest Checking ");
		
		// error checking to make sure the user gives the right number
		do{
			try{
				x = input.nextLine();
				type = Integer.parseInt(x);
				error = false;
				if (type > 2 || type < 0){
					System.out.println("INVALID ENTRY");
					System.out.println("Enter account type: ");
				}
			}catch(Exception e){
				System.out.println("INVALID ENTRY");
				System.out.println("Enter account type: ");
				error = true;
			}
		}while (type > 2 || type < 0 || error == true);
		
		System.out.println("Enter Deposit: ");
		do{
			try{
				x =input.nextLine();
				deposit = Double.parseDouble(x);
				error = false;
				if (deposit < 0){
					System.out.println("INVALID ENTRY");
					System.out.println("Enter deposit: ");
				}
			}catch(Exception e){
				System.out.println("INVALID ENTRY");
				System.out.println("Enter deposit: ");
				error = true;
				
			}
		}while (deposit < 0 || error == true);
		
		//depending on the number the user entered, an account will be created for their choice
		if(type==0){
			NonInterestCheckingAccount newAcct = new NonInterestCheckingAccount(accts.size()+1,name,"Checking",deposit);
			accts.add(newAcct);
		}
		if(type==1){
			InterestCheckingAccount newAcct = new InterestCheckingAccount(accts.size()+1,name,"Interest Checking",deposit,3.0f);
			accts.add(newAcct);
		}
		if(type==2){
			PlatinumCheckingAccount newAcct = new PlatinumCheckingAccount(accts.size()+1,name,"Platinum Checking",deposit,3.0f);
			accts.add(newAcct);
		}
		
	}
	public void closeAccount(){
		//asks for user input to close the account
		int close = 0;
		String x;
		boolean error = true;
		System.out.println("Enter the number of the account you would like to close: ");
		//if the user gives a number that doesn't correspond with any account or types in a letter
		// where there should be an int, it asks for a new entry
		do{
			try{
				x = input.nextLine();
				close = Integer.parseInt(x);
				error = false;
				if (close > accts.size()|| close < 1){
					System.out.println("INVALID ENTRY");
					System.out.println("Enter the number of the account you would like to close: ");
				}
			}catch(Exception e){
				System.out.println("INVALID ENTRY");
				System.out.println("Enter the number of the account you would like to close: ");
				error = true;
				
			}
		}while (close > accts.size()|| close < 1 || error == true);
		
		//a for loop is used to find the account with the number that the user entered. it is then removed 
		for(int i = 0; i< accts.size();i++){
			if (accts.get(i).getNum() == close){
			accts.remove(accts.get(i));
			}
		}
	}
	
	
	public void addInterest(){
		// using a for loop to get each account and add the interest to all those that have interest
		for(int i = 0; i<accts.size();i++){
			accts.get(i).addInterest();
		}
	}

	//used to alphabetize the accounts by checking the first letter of an account in relation to the other account
	private Account i;
	public Account check(){return i;}
	public void write(Account j){
		i = j;
	}
	public int compareTo(Bank mg){
		return check().compareTo(mg.check());
	}
	
	public void alphabetize(){
		//uses compareTo to rearrange the accounts in alphabetical order by name
		Account temp;
		for(int i = 0; i < accts.size();i++){
			for(int j = 0; j < accts.size();j++){
				
				if (accts.get(i).getName().compareTo(accts.get(j).getName()) <0){
					temp = accts.get(i);
					accts.set(i,accts.get(j));
					accts.set(j,temp);
				}
			}
		}
	}
	
	
	public void makeDeposit(int num, double deposit){
		//takes in a number and deposit amount and then adds that to that account's balance
		for(int i = 0; i< accts.size();i++){
			if (accts.get(i).getNum() == num){
				accts.get(i).changeBalance(deposit);
			}
		}
	}
	
	public void makeWithdrawal(int num, double withdrawal){
		//takes in a number and withdrawal amount and then subtracts that from that account's balance
		for(int i = 0; i< accts.size();i++){
			if (accts.get(i).getNum() == num){
				accts.get(i).changeBalance(-withdrawal);
			}
		}
	}
	
	public ArrayList <Account> getAccts(){
		//returns the array to AccountTest so that the accounts can be printed 
		return accts;
	}
	
	public String toString(){
		//used to print all of the data for each account
		return "Name: " +name+ ", Type: "+ type+", Balance: "+balance+", Interest Rate: "+interest +"\n";
	}
}