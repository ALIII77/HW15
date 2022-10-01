package Q1.service;

import Q1.entity.BankAccount;
import Q1.repository.BankAccountRepository;

public class BankAccountService {

    BankAccountRepository bankAccountRepository = new BankAccountRepository();

    public void deposit(long id, double deposit) {
        BankAccount account;
        account = bankAccountRepository.read(id);

        if (deposit > 0) {
            account.setBalance(account.getBalance() + deposit);
            update(account);
        } else {
            throw new IllegalArgumentException("Deposit value must be positive");
        }
    }

    public void withdraw(long id, double withdraw) {
        BankAccount account;
        account = bankAccountRepository.read(id);
        if (withdraw > 0) {
            if (account.getBalance() > withdraw) {
                account.setBalance(account.getBalance() - withdraw);
                update(account);
            } else throw new IllegalArgumentException("withdraw amount must be positive");
        } else throw new IllegalArgumentException("withdraw value must be positive");


    }

    public void create(BankAccount account) {
        bankAccountRepository.create(account);
    }

    public void delete(BankAccount account) {
        bankAccountRepository.delete(account);
    }

    public void delete(long id) {
        BankAccount account = bankAccountRepository.read(id);
        bankAccountRepository.delete(account);
    }

    public void update(BankAccount account) {
        bankAccountRepository.update(account);
    }

    public BankAccount load(BankAccount account) {
        return bankAccountRepository.read(account);
    }

}

