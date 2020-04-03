package ch.hesge.programmation.models;

import java.util.Date;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private Date date;

    public Person(String firstName, String lastName, Date date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
