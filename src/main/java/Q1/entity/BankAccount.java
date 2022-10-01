package Q1.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BankAccount {

    @Id
    @GenericGenerator(name="IdGenerator",strategy = "DepartmentIdGenerator")
    @GeneratedValue(generator = "IdGenerator")
    private long accountNumber;
    @Column(length = 16,unique = true)

    private String cardNumber;

    private LocalDate createAccountDate;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private double balance;

    private int cvv2;

    private LocalDate expirationDate;

    public BankAccount(String cardNumber, LocalDate createAccountDate, AccountType accountType, double balance, LocalDate expirationDate) {
        this.cardNumber = cardNumber;
        this.createAccountDate = createAccountDate;
        this.accountType = accountType;
        this.balance = balance;
        this.expirationDate = expirationDate;
        this.cvv2=new Random().nextInt(1111 , 9999);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount account = (BankAccount) o;
        return accountNumber == account.accountNumber && cvv2 == account.cvv2 && Objects.equals(cardNumber, account.cardNumber) && Objects.equals(createAccountDate, account.createAccountDate) && accountType == account.accountType && Objects.equals(expirationDate, account.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, cardNumber, createAccountDate, accountType, cvv2, expirationDate);
    }
}
