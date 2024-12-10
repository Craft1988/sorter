package org.mike.project.base_entity;

import org.mike.project.data.PersonData;
import org.mike.project.interfaces.IAutobuilder;
import org.mike.project.interfaces.ISortableCustomClass;

import java.util.Comparator;
import java.util.Random;

public class Student implements ISortableCustomClass {
    private final int id;
    private final String lastName;
    private final String firstName;

    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
    }

    public static class StudentBuilder implements IAutobuilder {
        private int id;
        private String firstName;
        private String lastName;

        public StudentBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }


        @Override
        public StudentBuilder randomAutoSet() {
            if ((int) (Math.random() * 100) > 50) {
                this.lastName = PersonData.FEMALE_LAST_NAMES.getRandomValue();
                this.firstName = PersonData.FEMALE_FIRST_NAMES.getRandomValue();
            } else {
                this.lastName = PersonData.MALE_LAST_NAMES.getRandomValue();
                this.firstName = PersonData.MALE_FIRST_NAMES.getRandomValue();
            }
            this.id = new Random().nextInt(Integer.MAX_VALUE);
            return this;
        }

        @Override
        public IAutobuilder fromFileAutoSet() {
            return null;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public Comparator<Student> getCustomComparator() {
        return Comparator.comparing(Student::getLastName)
                .thenComparing(Student::getFirstName)
                .thenComparing(Student::getId);
    }

    @Override
    public String toString() {
        return "Student:" +
                lastName + " " + firstName + " with id: " + id;
    }
}