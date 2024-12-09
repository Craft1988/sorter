package org.mike.project.utils;

import org.mike.project.interfaces.ISortableCustomClass;

import java.util.ArrayList;
import java.util.List;

public class Creator {
    public static List<ISortableCustomClass> getList(int choose) {
        List<ISortableCustomClass> p = new ArrayList<>();
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
