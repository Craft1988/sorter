package org.mike.project.utils;

import org.mike.project.base_entity.Animal;
import org.mike.project.base_entity.Person;
import org.mike.project.base_entity.Student;
import org.mike.project.interfaces.SortableCustomClass;

import java.util.ArrayList;
import java.util.List;

public class Creator {
    public static List<SortableCustomClass> getList(int choose) {
        List<SortableCustomClass> p = new ArrayList<>();
        switch (choose) {
            case 1 -> {
                //TODO list of Persons.
            }
            case 2 -> {
                //TODO list of Animals.
            }
            case 3 -> {
                //TODO list of Students.
            }
        }
        return p;
    }
}
