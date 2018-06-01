package bankteller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bank {
	Map<String, BankAccount> accounts = new HashMap<>();

	public void add(BankAccount account) {
		accounts.put(account.getAccountNumber(), account);
		
		
	}

	public BankAccount findAccount(String accountNum) {

		return accounts.get(accountNum);
	}

	public Collection<BankAccount> getAllAccounts() {
		return accounts.values();
	}

	public void close(BankAccount account) {
		accounts.remove(account.getAccountNumber(), account);

	}

	public void withdraw(String accountNumber, int amount) {
		BankAccount withdrawFromAccount = findAccount(accountNumber);
		withdrawFromAccount.withdraw(amount);
	}

	public void add(String accountNumber, int amount) {
		BankAccount depositToAccount = findAccount(accountNumber);
		depositToAccount.deposit(amount);
	}

	
  
}
