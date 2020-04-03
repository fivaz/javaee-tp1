package ch.hesge.programmation.models;

import java.util.ArrayList;
import java.util.List;

public class BDD {

    private static List<Person> people = new ArrayList<>();

    public List<Person> getPeople() {
        return people;
    }

    public void add(Person person) {
        people.add(person);
    }
}
