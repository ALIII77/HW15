package Q1test;

import Q1.entity.AccountType;
import Q1.entity.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Q1.repository.BankAccountRepository;
import Q1.service.BankAccountService;

import java.time.LocalDate;

public class BankAccountTest {

     BankAccount bankAccount;
     BankAccountRepository bankAccountRepository;
     static BankAccountService bankAccountService;

    @BeforeAll
    public static void initialization(){
        bankAccountService= new BankAccountService();

    }
    @BeforeEach
    public void runBeforeTest() {
        bankAccount = new BankAccount( "123456789012345",
                LocalDate.of(1991, 02, 23),
                AccountType.INTERESTEDFREELOAN,
                6000,
                LocalDate.of(1997, 03, 20));
        bankAccountRepository = new BankAccountRepository();

    }
    @Test
    public void testSavingAccount() {
        bankAccountService.create(bankAccount);
        Assertions.assertEquals(bankAccount, bankAccountService.load(bankAccount));
    }
    @Test
    public void testDeleteAccount(){
        bankAccount = new BankAccount( "12345678909999",
                LocalDate.of(1992, 07, 29),
                AccountType.LONGTERM, 3000,
                LocalDate.of(1998, 01, 04));
        bankAccountService.create(bankAccount);
        bankAccountService.delete(bankAccount);
        Assertions.assertNull(bankAccountService.load(bankAccount));
    }
    @Test
    public void testUpdateAccount(){
        bankAccountService.create(bankAccount);
        BankAccount bankAccountUpdate;
        bankAccountUpdate = new BankAccount(bankAccount.getAccountNumber(),
                "12345678909999",
                LocalDate.of(1992, 07, 29),
                AccountType.LONGTERM,
                3000, bankAccount.getCvv2(),
                LocalDate.of(1998, 01, 04));
        bankAccountService.update(bankAccountUpdate);
        Assertions.assertEquals(bankAccountUpdate,bankAccountService.load(bankAccount));
    }
    @Test
    public void testReadAccount(){
        bankAccountService.create(bankAccount);
        Assertions.assertEquals(bankAccount,bankAccountService.load(bankAccount));
    }
    @Test
    public void testDeposit(){
        bankAccountService.create(bankAccount);
        double accountBalance=bankAccount.getBalance();
        bankAccountService.deposit(bankAccount.getAccountNumber(),4000);
        Assertions.assertEquals(accountBalance+4000,bankAccountService.load(bankAccount).getBalance());
    }
    @Test
    public void testNegativeDepostiValue(){
        bankAccountService.create(bankAccount);
        Assertions.assertThrows(Exception.class,
                ()->bankAccountService.deposit(bankAccount.getAccountNumber(),-400));
    }
    @Test
    public void testWithdraw(){

        bankAccountService.create(bankAccount);
        double accountBalance=bankAccount.getBalance();
        bankAccountService.withdraw(bankAccount.getAccountNumber(),1000);
        Assertions.assertEquals(accountBalance-1000,bankAccountService.load(bankAccount).getBalance());


        bankAccountService.create(bankAccount);
        Assertions.assertThrows(Exception.class,
                () -> bankAccountService.withdraw(bankAccount.getAccountNumber(), -400));


        bankAccountService.create(bankAccount);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> bankAccountService.withdraw(bankAccount.getAccountNumber(),
                        7000));

    }
}
