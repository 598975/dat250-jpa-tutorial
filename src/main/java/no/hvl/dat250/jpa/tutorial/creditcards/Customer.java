package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name="customer_address",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")}
    )
    private Collection<Address> addresses;

    @ManyToMany
    @JoinTable(
            name="customer_creditCard",
            joinColumns = {@JoinColumn(name="customer_id")},
            inverseJoinColumns = {@JoinColumn(name="creditCard_id")}
    )
    private Collection<CreditCard> creditCards;

    public Customer() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Collection<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    public Collection<CreditCard> getCreditCards() {
        return this.creditCards;
    }

    public void setCreditCards(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}
