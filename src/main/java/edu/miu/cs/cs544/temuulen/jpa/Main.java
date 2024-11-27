package edu.miu.cs.cs544.temuulen.jpa;

import edu.miu.cs.cs544.temuulen.jpa.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        System.out.println("Application started");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Room
        Room room = new Room();
        room.setRoomNumber("218");
        em.persist(room);

        // Course
        Course course = new Course();
        course.setTitle("Enterprise Architecture");
        course.setCapacity(30);
        course.setNumber(544);
        course.setRoom(room);
        em.persist(course);

        // Student
        Student student = new Student();
        student.setName("Temuulen");
        student.setGpa(40);
        student.setCourse(course);
        em.persist(student);

        // Person (Owner)
        Person owner = new Person();
        owner.setName("Bob");
        em.persist(owner);

        // Person (Driver)
        Person driver = new Person();
        driver.setName("Charlie");
        em.persist(driver);

        // Car
        Car car = new Car();
        car.setModel("Sedan");
        car.setOwner(owner);
        car.setDriver(driver);
        em.persist(car);

        // Owner to car
        owner.setOwnedCar(car);

        em.getTransaction().commit();
        em.close();
    }
}
