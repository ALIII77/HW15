import Q1.entity.AccountType;
import Q1.entity.BankAccount;
import Q1.service.BankAccountService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        BankAccountService bankAccountService = new BankAccountService();


        BankAccount bankAccount1 = new BankAccount("9082734982734",
                LocalDate.of(1991, 8, 27),
                AccountType.CURRENTACCOUNT,
                6000,
                LocalDate.of(1998, 9, 14));

        BankAccount bankAccount2 = new BankAccount("9082734989987",
                LocalDate.of(1991, 8, 27),
                AccountType.LONGTERM,
                9000,
                LocalDate.of(1990, 7, 20));


        bankAccountService.create(bankAccount1);
        bankAccountService.create(bankAccount2);


    }
}
