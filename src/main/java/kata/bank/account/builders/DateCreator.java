package kata.bank.account.builders;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateCreator {

	private DateCreator() {
		throw new IllegalStateException("Utility class");
	}

	public static LocalDate date(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(dateString, formatter);
	}

}
