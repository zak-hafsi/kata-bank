package kata.bank.account.domain;

import kata.bank.account.builders.DateCreator;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class DateCreatorTest {
	
	@Test public void
	should_create_a_date_from_string() {
		LocalDate date = DateCreator.date("10/01/2012");

		assertEquals(date, LocalDate.of(2012, 01, 10));
	}
	
}
