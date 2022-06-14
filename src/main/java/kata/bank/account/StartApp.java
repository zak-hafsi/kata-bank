package kata.bank.account;

import kata.bank.account.builders.DateCreator;
import kata.bank.account.domain.Account;
import kata.bank.account.domain.Amount;
import kata.bank.account.domain.Statement;

public class StartApp {

    public static void main(String[] args) {
        Account account = new Account(new Statement());

        account.deposit(Amount.amountOf(1000), DateCreator.date("10/01/2022"));
        account.deposit(Amount.amountOf(2000), DateCreator.date("13/02/2022"));

        account.withdrawal(Amount.amountOf(500), DateCreator.date("14/02/2022"));
        account.withdrawal(Amount.amountOf(20), DateCreator.date("15/03/2022"));
        account.withdrawal(Amount.amountOf(345), DateCreator.date("16/05/2022"));

        account.deposit(Amount.amountOf(1500), DateCreator.date("19/06/2022"));

        account.printStatement(System.out);
    }
}
