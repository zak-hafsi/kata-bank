package kata.bank.account.builders;

import kata.bank.account.domain.Amount;
import kata.bank.account.domain.Transaction;

import java.time.LocalDate;

public class TransactionBuilder {
	
	private LocalDate date;
	private Amount value;

	public static TransactionBuilder aTransaction() {
		return new TransactionBuilder();
	}

	public TransactionBuilder with(LocalDate date) {
		this.date = date;
		return this;
	}

	public TransactionBuilder with(Amount value) {
		this.value = value;
		return this;
	}

	public Transaction build() {
		Transaction transaction = new Transaction(value, date);
		return transaction;
	}
	
	

}
