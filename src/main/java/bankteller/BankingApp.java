package bankteller;

import java.util.Scanner;

public class BankingApp {
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	Bank myBank = new Bank();
	BankAccount account1 = new BankAccount("1111", "Checking", 500);
	BankAccount account2 = new BankAccount("2222", "Savings", 2500);
	
myBank.add(account2);
myBank.add(account1);

System.out.println("Here are your accounts at our bank: ");
System.out.println(account1.getType() + " " + account1.getBalance());
System.out.println(account2.getType() + " " + account2.getBalance());
System.out.println("what would you like to do?");
System.out.println("Press 1 to deposit");
System.out.println("Press 2 to withdraw");
System.out.println("Press 3 to check balance");
System.out.println("Press 4 to close an account");
System.out.println("Press -1 to exit");

 int userChoice = input.nextInt();
 input.nextLine();
 if(userChoice == 1) {
	 System.out.println("You want to deposit");
	 System.out.println("Here are your accounts");
	 System.out.println("(" + account1.getAccountNumber() + ")" + " " + account1.getType() + " " + account1.getBalance());
 System.out.println("Select account by (acct num) to perform this transaction");
 String accountNumber = input.nextLine();
 System.out.println("You have selected " + accountNumber);
 System.out.println("Enter the amount to deposit: ");
 int amountToDeposit = input.nextInt();
 System.out.println("Your updated balance is now:");
 if(accountNumber.equalsIgnoreCase("1111")) {
	 account1.deposit(amountToDeposit);
 System.out.println("your new Balance: ");
System.out.println(account1.getBalance());

}
}
}
}