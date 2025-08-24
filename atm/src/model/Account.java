package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
public class Account {
    String accountNumber;
    String userName;
    Card card;
    @Setter
    int balance;

    public Account(String accountNumber, String userName, Card card, int balance) {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.card = card;
        this.balance = balance;
    }
}
