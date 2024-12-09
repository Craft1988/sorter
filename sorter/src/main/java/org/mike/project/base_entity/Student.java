package org.mike.project.base_entity;

import org.mike.project.interfaces.SortableCustomClass;

import java.util.Comparator;

public class Student implements SortableCustomClass {
    private final Integer id;
    private final String lastName;
    private final String firstName;

    public Student(Integer id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
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
        return Comparator.comparing(Student::getId)
                .thenComparing(Student::getLastName)
                .thenComparing(Student::getFirstName);
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