package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pincode;
    private int count;

    public Pincode() {}

    public Long getId() {
        return id;
    }

    public String getCode() {
        return this.pincode;
    }

    public void setCode(String pincode) {
        this.pincode = pincode;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
