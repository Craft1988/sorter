package org.mike.project.utils;

import org.mike.project.interfaces.ISortableCustomClass;

import java.util.Comparator;
import java.util.List;

public class Handler {
    public static <T extends ISortableCustomClass> void insertionSort(List<T> unsorted, Comparator<T> c) {
        if (unsorted.size() < 2) {
            return;
        }
        if (c == null) {
            System.out.println("Unable to sort the collection without comparator");
            return;
        }

        for (int i = 1; i < unsorted.size(); i++) {
            for (int j = i; j > 0; j--) {
                T temp = unsorted.get(j - 1);
                if (c.compare(temp, unsorted.get(j)) > 0) {
                    unsorted.set(j - 1, unsorted.get(j));
                    unsorted.set(j, temp);
                }
            }
        }
    }


    public static<T extends ISortableCustomClass> int binarySearch(List<T> sorted, Comparator<T> c) {
        // TODO: Add a binary search implementation
        return -1;
    }
}
