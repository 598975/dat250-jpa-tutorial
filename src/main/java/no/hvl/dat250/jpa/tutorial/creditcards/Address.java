package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private int number;

    @ManyToMany(mappedBy = "addresses", fetch = FetchType.EAGER)
    private Collection<Customer> owners;

    public Address() {}

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Collection<Customer> getOwners() {
        return new HashSet<>(this.owners);
    }

    public void setOwners(Collection<Customer> owners) {
        this.owners = owners;
    }
}
