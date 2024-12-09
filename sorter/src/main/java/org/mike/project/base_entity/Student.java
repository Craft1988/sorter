package org.mike.project.base_entity;

import org.mike.project.interfaces.ISortableCustomClass;

import java.util.Comparator;

public class Student implements ISortableCustomClass {
    private final int id;
    private final String lastName;
    private final String firstName;

    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
    }

    public static class StudentBuilder {
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
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}