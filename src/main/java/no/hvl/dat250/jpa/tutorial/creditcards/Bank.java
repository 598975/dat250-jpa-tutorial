package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "owningBank", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<CreditCard> cards;

    public Bank() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<CreditCard> getOwnedCards() {
        return new HashSet<>(this.cards);
    }

    public void setOwnedCards(Collection<CreditCard> cards) {
        this.cards = cards;
    }
}
