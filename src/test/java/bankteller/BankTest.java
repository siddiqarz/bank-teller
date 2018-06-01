package bankteller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public class BankTest {
	Bank underTest;
	BankAccount account1;
	BankAccount account2;

	@Before // sets up the project so that you can have objects that exist wehn the test is
			// run.
	public void setUp() {
		underTest = new Bank();
		account1 = new BankAccount("1", "Checking", 100);
		account2 = new BankAccount("2", "Savings", 100);
	}

	@Test
	public void addAccount() {
		underTest.add(account1);
		BankAccount retrievedAccount = underTest.findAccount("1");
		assertThat(retrievedAccount, is(account1));
	}

	@Test
	public void shouldBeAbleToAddTwoAccounts() {
		underTest.add(account2);
		underTest.add(account1);
		Collection<BankAccount> allAccounts = underTest.getAllAccounts();
		// doesn't matter what order it's sorted in. Can use "contains" if order matters
		assertThat(allAccounts, containsInAnyOrder(account1, account2));
		assertEquals(2, allAccounts.size());
	}

	@Test
	public void shouldBeAbleToCloseAnAccount() {
		underTest.add(account1);
		underTest.close(account1);
		BankAccount retrievedAccount = underTest.findAccount(account1.getAccountNumber());
		assertThat(retrievedAccount, is(nullValue()));
	}

	@Test
	public void shouldwithdrawFromAccount() {
		underTest.add(account1);
		underTest.withdraw(account1.getAccountNumber(), 50);
		assertThat(account1.getBalance(), is(50));
	}

	@Test
	public void shouldDepositToAccount() {
		underTest.add(account1);
		underTest.add(account1.getAccountNumber(), 20);
		assertThat(account1.getBalance(), is(120));
	}
}
