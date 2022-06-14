package kata.bank.account.domain;

import org.junit.Test;

import static kata.bank.account.domain.Amount.amountOf;
import static org.junit.Assert.*;

public class AmountTest {
	
	@Test public void
	should_be_equal_to_another_instance_containing_same_amount() {
		Amount oneHundred = new Amount(100);
		Amount anotherOneHundred = new Amount(100);
		
		assertEquals(oneHundred, anotherOneHundred);
	}

	@Test public void
	should_be_different_from_another_instance_containing_different_amount() {
		Amount ten = new Amount(10);
		Amount five = new Amount(5);
		
		assertNotEquals(ten, five);
	}
	
	@Test public void
	should_statically_initialise_an_amount() {
		assertEquals(new Amount(10), amountOf(10));
	}
	
	@Test public void
	should_sum_up_amounts() {
		Amount ten = amountOf(10);
		Amount five = amountOf(5);
		Amount fifteen = amountOf(15);
		
		assertEquals(fifteen, ten.plus(five));
	}
	
	@Test public void
	should_indicate_when_it_is_greater_than_other_amount() {
		Amount ten = amountOf(10);
		Amount five = amountOf(5);
		
		assertTrue(ten.isGreaterThan(five));
	}
	
	@Test public void
	should_indicate_when_it_is_not_greater_than_other_amount() {
		Amount ten = amountOf(10);
		Amount five = amountOf(5);
		
		assertFalse(five.isGreaterThan(ten));
	}
	
	@Test public void
	should_return_the_absolute_value() {
		Amount minusFive = amountOf(-5);
		
		assertEquals(amountOf(5), minusFive.absoluteValue());
	}
	
	@Test public void
	should_return_the_negative_value() {
		Amount five = amountOf(5);
		
		assertEquals(amountOf(-5), five.negative());
	}
	
	@Test public void
	should_return_money_representation() {
		Amount oneThousand = amountOf(1000);
		
		assertEquals("1000,00", oneThousand.moneyRepresentation());
	}
	
}
