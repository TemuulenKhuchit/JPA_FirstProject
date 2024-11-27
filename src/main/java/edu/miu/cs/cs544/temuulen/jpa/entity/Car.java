package edu.miu.cs.cs544.temuulen.jpa.entity;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Person driver;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private Person owner;

    public Car(){}

    public Car(String model, Person driver, Person owner) {
        this.model = model;
        this.driver = driver;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
