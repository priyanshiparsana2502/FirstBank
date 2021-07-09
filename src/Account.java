import java.util.Scanner;

public class Account {
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	//class Constructor
	Account (String cname, String cid) {
		customerName = cname;
		customerID= cid;
	}
	
	//Function for depositing money
	void deposit (int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	//Function for withdrawing money
	void withdraw (int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	//Function showing the previous transaction
	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println ("Withdrawn: "+ Math.abs(previousTransaction));
		} else {
			System.out.println("No transaction occured");
		}
	}
	
	//Function for calculating interest of current funds after number of years
	void calculateInterest(int years) {
		double interestRate = .0185;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("The current interest rate is " + (100 * interestRate) + "%");
		System.out.println("After" + years + " years, your balance will be: " + newBalance);  
	}
	
	//Function showing the main menu
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your id is: " + customerID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("A. Check your balance.");
		System.out.println("B. Make a deposit.");
		System.out.println("C. Make a withdrawal.");
		System.out.println("D. View previous transaction.");
		System.out.println("E. Calculate interest.");
		System.out.println("F. Exit.");
		
		do {
			System.out.println();
			System.out.println("Enter an option:");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			case 'A':
				System.out.println("======================================");
				System.out.println("Balance = $" + balance);
			    System.out.println("======================================");
			    System.out.println();
			    break;
			
			case 'B':
				System.out.println("Enter an amount to deposit: ");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("");
				break;
				
			case 'C':
				System.out.println("Enter amount to withdraw: ");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println("");
				break;
				
			case 'D':
				System.out.println("======================================");
				getPreviousTransaction();
				System.out.println("======================================");
				System.out.println();
				break;
				
			case 'E':
				System.out.println("Enter how many years of accured interest: ");
				int years = scanner.nextInt();
				calculateInterest(years);
				break;
				
			case 'F':
				System.out.println("=======================================");
				break;
				
			default:
				System.out.println("Error: Invalid option. Please enter valid option.");
				break;
			}	
		} while(option != 'F');
		System.out.println("Thank you for banking with us!");
	}
	
}