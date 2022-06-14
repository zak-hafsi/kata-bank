package kata.bank.account.domain;

import java.io.PrintStream;
import java.time.LocalDate;

import static kata.bank.account.domain.Amount.amountOf;


public class Account {

	private Statement statement;
	
	private Amount balance = amountOf(0);

	public Account(Statement statement) {
		this.statement = statement;
	}

	public void deposit(Amount value, LocalDate date) {
		recordTransaction(value, date);
	} 

	public void withdrawal(Amount value, LocalDate date) {
		recordTransaction(value.negative(), date);
	}

	public void printStatement(PrintStream printer) {
		statement.printTo(printer);
	}

	private void recordTransaction(Amount value, LocalDate date) {
		Transaction transaction = new Transaction(value, date);
		Amount balanceAfterTransaction = transaction.balanceAfterTransaction(balance);
		balance = balanceAfterTransaction;
		statement.addLineContaining(transaction, balanceAfterTransaction);
	}
	
}
