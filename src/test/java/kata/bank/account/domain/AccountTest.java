package kata.bank.account.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.time.LocalDate;

import static kata.bank.account.builders.DateCreator.date;
import static kata.bank.account.builders.TransactionBuilder.aTransaction;
import static kata.bank.account.domain.Amount.amountOf;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
	
	@Mock
	Statement statement;
	private Account account;

	@Before
	public void initialise() {
		account = new Account(statement);
	}
	
	@Test public void
	should_add_deposit_line_to_statement() {
		LocalDate depositDate = date("10/01/2012");
		Amount depositAmount = amountOf(1000);
		
		account.deposit(depositAmount, depositDate);
		
		verify(statement).addLineContaining(aTransaction()
												.with(depositDate)
												.with(depositAmount).build(),
											currentBalanceEqualsTo(depositAmount));
	}
	
	@Test public void
	should_add_withdraw_line_to_statement() {
		LocalDate withdrawalDate = date("12/01/2012");
		
		account.withdrawal(amountOf(500), withdrawalDate);
		
		verify(statement).addLineContaining(aTransaction()
											.with(amountOf(-500))
											.with(withdrawalDate).build(), 
											amountOf(-500));
	}
	
	@Test public void
	should_print_statement() {
		PrintStream printer = System.out;
		
		account.printStatement(printer);
		
		verify(statement).printTo(printer);
	}
	
	private Amount currentBalanceEqualsTo(Amount amount) {
		return amount;
	}

}
