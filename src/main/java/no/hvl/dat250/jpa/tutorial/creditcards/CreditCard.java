package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private int creditLimit;
    private int balance;

    @ManyToOne
    private Bank owningBank;

    @ManyToOne
    private Pincode pincode;

    public CreditCard() {}

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Integer getCreditLimit() {
        return this.creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Pincode getPincode() {
        return this.pincode;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public Bank getOwningBank() {
        return this.owningBank;
    }

    public void setOwningBank(Bank owningBank) {
        this.owningBank = owningBank;
    }
}
