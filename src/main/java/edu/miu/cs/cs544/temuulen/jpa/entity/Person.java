package edu.miu.cs.cs544.temuulen.jpa.entity;

import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "owner")
    private Car ownedCar;

    public Person() {}

    public Person(String name, Car ownedCar) {
        this.name = name;
        this.ownedCar = ownedCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getOwnedCar() {
        return ownedCar;
    }

    public void setOwnedCar(Car ownedCar) {
        this.ownedCar = ownedCar;
    }

    public Long getId() {
        return id;
    }
}
