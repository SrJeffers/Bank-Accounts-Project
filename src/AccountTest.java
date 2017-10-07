/*
 * Sean Jeffers 
 * COSC 201
 * October 9, 2015
 * October 9th First project
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;


public class AccountTest {
	
	public static void main(String[] args){
		
		//declaring all of the necessary variables
		Bank entry = new Bank();
		String fyle= args[0];
		String name;
		String type;
		String nxt;
		Double balance;
		float interest;
		int num=1;
		int aNum =0;
		double deposit = 0, withdrawal = 0;
		boolean error = true;
		String x;
		
		try{
			//declaring scanners for user input and the file
			Scanner userInput;
			userInput = new Scanner(System.in);
			Scanner input;
			input = new Scanner(new File(fyle));
			
			//if statement checking to see if the file is empty
			if(input.hasNextLine()== false){
				System.out.println("File was empty");
			}else{
				while(input.hasNextLine() == true){
					nxt = input.nextLine();
					String words[];
					words = new String[4];
					//splitting the parts of the first line into a string array which determines the elements of the accounts
					words= nxt.split(", ");
					// found at http://stackoverflow.com/questions/4574041/read-next-word-in-java
					name = words[0];
					type = words[1];
					balance = Double.parseDouble(words[2]);
					// creating the accounts which are sent to bank and placed into an array of accounts
					if(type.equals("Checking")){
						NonInterestCheckingAccount acct = new NonInterestCheckingAccount(num,name,type,balance);
						entry.addAccount(acct);
					}
					if(type.equals("Interest Checking")){
						interest = Float.parseFloat(words[3]);
						InterestCheckingAccount acct = new InterestCheckingAccount(num,name,type,balance,interest);
						entry.addAccount(acct);
					}
					if(type.equals("Platinum Checking")){
						interest = Float.parseFloat(words[3]);
						PlatinumCheckingAccount acct = new PlatinumCheckingAccount(num,name,type,balance,interest);
						entry.addAccount(acct);
					}
					
					
					num++;
				}
				//Calling all of the statements in bank and asking for user input
				entry.alphabetize();
				DecimalFormat df = new DecimalFormat("#.##");
				System.out.println("Total assets of the bank: "+df.format(entry.totalAssets()));
				System.out.println("***Printing Accounts***");
				System.out.println(entry.getAccts().toString());
				entry.addInterest();
				
				System.out.println("***Adding Interest***");
				System.out.println("Total assets of the bank: "+df.format(entry.totalAssets()));
				System.out.println("***Make Deposit***");
				System.out.println("In which account would you like to make a deposit: ");
				//if the user gives a number that doesn't correspond with any account or types in a letter
				// where there should be an int, it asks for a new entry
				do{
					try{
						x =userInput.nextLine();
						aNum = Integer.parseInt(x);
						error = false;
						if (aNum > entry.getAccts().size() || aNum < 1){
							System.out.println("INVALID ENTRY");
							System.out.println("In which account would you like to make a deposit: ");
						}
					}catch(Exception e){
						System.out.println("INVALID ENTRY");
						System.out.println("In which account would you like to make a deposit: ");
						error = true;
						
					}
				}while (aNum > entry.getAccts().size() || aNum < 1 || error == true);
				
				
			
				


				System.out.println("Choose deposit amount:");
				//if the user gives an input that is less than 0 or isn't a number, it asks for new input
				do{
					try{
						x =userInput.nextLine();
						deposit = Double.parseDouble(x);
						error = false;
						if (deposit < 0){
							System.out.println("INVALID ENTRY");
							System.out.println("Choose deposit amount: ");
						}
					}catch(Exception e){
						System.out.println("INVALID ENTRY");
						System.out.println("Choose deposit amount: ");
						error = true;
						
					}
				}while (deposit < 0 || error == true);
				
				entry.makeDeposit(aNum, deposit);
				
				System.out.println("***Make Withdrawal***");
				System.out.println("In which account would you like to make a withdrawal: ");
				aNum =userInput.nextInt();
				//if the user gives a number that doesn't correspond with any account or types in a letter
				//where there should be an int, it asks for a new entry
				do{
					try{
						x =userInput.nextLine();
						aNum = Integer.parseInt(x);
						error = false;
						if (aNum > entry.getAccts().size() || aNum < 1){
							System.out.println("INVALID ENTRY");
							System.out.println("In which account would you like to make a withdrawal: ");
						}
					}catch(Exception e){
						System.out.println("INVALID ENTRY");
						System.out.println("In which account would you like to make a withdrawal: ");
						error = true;
						
					}
				}while (aNum > entry.getAccts().size() || aNum < 1 || error == true);
				
				
				
				System.out.println("Choose withdrawal amount:");
				
				//if the user enters an amount that is greater than the balance of that particular account 
				//the program will ask for a new withdrawal amount
				do{
					try{
						x =userInput.nextLine();
						withdrawal = Double.parseDouble(x);
						error = false;
						if (withdrawal < 0 ){
							System.out.println("INVALID ENTRY");
							System.out.println("Choose withdrawal amount: ");
						}
						if (withdrawal > entry.getAccts().get(aNum).getBalance()){
							System.out.println("There is not enough money in the account");
							System.out.println("Choose withdrawal amount: ");
						}
					}catch(Exception e){
						System.out.println("INVALID ENTRY");
						System.out.println("Choose withdrawal amount: ");
						error = true;
					}
				}while (withdrawal < 0 || withdrawal > entry.getAccts().get(aNum).getBalance() || error == true);
				
				
				
				entry.makeWithdrawal(aNum, withdrawal);
				entry.openAccount();
				System.out.println("***Close Account***");
				entry.closeAccount();
				entry.alphabetize();
				
				System.out.println(entry.getAccts().toString());
				input.close();
				userInput.close();
			}
		}catch (FileNotFoundException caught){
			// in case file can't be found
			System.out.println("File " + fyle + " couldn't be opened.");
		}	
	}
}