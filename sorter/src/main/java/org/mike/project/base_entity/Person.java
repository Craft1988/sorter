package org.mike.project.base_entity;

import org.mike.project.interfaces.SortableCustomClass;

import java.util.Comparator;

public class Person implements SortableCustomClass {
    private final String firstName;
    private final String lastName;
    private final Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public Comparator<Person> getCustomComparator() {
        return Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getFirstName)
                .thenComparing(Person::getAge);
    }

    @Override
    public String toString() {
        return "Person{" +
                lastName +
                ", " + firstName +
                ", " + age +
                '}';
    }
}