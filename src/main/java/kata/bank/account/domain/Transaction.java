package kata.bank.account.domain;

import org.apache.commons.lang3.StringUtils;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static kata.bank.account.domain.Amount.amountOf;


public class Transaction {

	private static final String DATE_FORMAT = "dd/MM/yyyy";
	private static final String EMPTY_VALUE = "          ";

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

	private Amount value;
	private LocalDate date;

	public Transaction(Amount value, LocalDate date) {
		this.value = value;
		this.date = date;
	}

	public Amount balanceAfterTransaction(Amount currentBalance) {
		return currentBalance.plus(value);
	}
	
	public void printTo(PrintStream printer, Amount currentBalance) {
		StringBuilder builder = new StringBuilder();
		addDateTo(builder);
		addValueTo(builder);
		addCurrentBalanceTo(builder, currentBalance);
		printer.println(builder.toString());
	}

	private void addCurrentBalanceTo(StringBuilder builder, Amount currentBalance) {
		builder.append("| ")
			   .append(currentBalance.moneyRepresentation());
	}

	private void addValueTo(StringBuilder builder) {
		if (value.isGreaterThan(amountOf(0))) {
			addCreditTo(builder);
		} else {
			addDebitTo(builder);
		}
	}

	private void addDebitTo(StringBuilder builder) {
		builder.append(EMPTY_VALUE)
			   .append("|")
			   .append(valueToString());
	}

	private void addCreditTo(StringBuilder builder) {
		builder.append(valueToString())
				.append("|")
				.append(EMPTY_VALUE);
	}

	private String valueToString() {
		String stringValue = " " + value.absoluteValue().moneyRepresentation();
		return StringUtils.rightPad(stringValue, 10);
	}

	private void addDateTo(StringBuilder builder) {
		builder.append(formatter.format(date));
		builder.append(" |");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Transaction that = (Transaction) o;
		return Objects.equals(value, that.value) && Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, date);
	}
}
