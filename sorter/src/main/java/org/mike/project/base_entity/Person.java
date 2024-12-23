package org.mike.project.base_entity;

import org.mike.project.interfaces.SortableCustomClass;

import java.util.Comparator;

public class Person implements SortableCustomClass {
    private final String firstName;
    private final String lastName;
    private final int age;

    private Person(PersonBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
    }

    public static class PersonBuilder {
        private String firstName;
        private String lastName;
        private int age;

        public PersonBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
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
        return lastName +
                " " + firstName +
                " - " + age +
                " years old";
    }
}