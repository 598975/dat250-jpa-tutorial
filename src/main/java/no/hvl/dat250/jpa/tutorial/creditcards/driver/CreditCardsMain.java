package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.Set;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    //New customer
    Customer customer = new Customer();
    customer.setName("Max Mustermann");

    //New address for customer
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);
    address.setOwners(Set.of(customer));
    customer.setAddresses(Set.of(address));

    //New bank
    Bank bank = new Bank();
    bank.setName("Pengebank");

    //1. new credit card
    CreditCard creditCard1 = new CreditCard();
    creditCard1.setNumber(12345);
    creditCard1.setBalance(-5000);
    creditCard1.setCreditLimit(-10000);
    creditCard1.setOwningBank(bank);

    //2. new credit card
    CreditCard creditCard2 = new CreditCard();
    creditCard2.setNumber(123);
    creditCard2.setBalance(1);
    creditCard2.setCreditLimit(2000);
    creditCard2.setOwningBank(bank);

    //New pincode
    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    //Add cards to bank
    bank.setOwnedCards(Set.of(creditCard1, creditCard2));

    //Add cards to customer
    customer.setCreditCards(Set.of(creditCard1, creditCard2));


    //Add pincode to cards
    creditCard1.setPincode(pincode);
    creditCard2.setPincode(pincode);

    em.persist(customer);
    em.persist(creditCard1);
    em.persist(creditCard2);
    em.persist(pincode);
    em.persist(bank);
    em.persist(address);
  }
}
