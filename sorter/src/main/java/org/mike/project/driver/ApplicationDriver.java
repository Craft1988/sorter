package org.mike.project.driver;

import org.mike.project.interfaces.ISortableCustomClass;
import org.mike.project.utils.Creator;
import org.mike.project.utils.Handler;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static org.mike.project.utils.Console.*;

public class ApplicationDriver {
    private static List<ISortableCustomClass> list;
    private final static Scanner sc = new Scanner(System.in);
    private static int choose;
    private static boolean isSorted;

    public void start() {
        showStartMenu();
        choose = sc.nextInt();
        switch (choose) {
            case 1 -> driveSubmenu();

            case 2 -> {
                if (list == null || list.isEmpty()) {
                    System.out.println("List is empty.");
                    showStartMenu();
                }
                list.forEach(System.out::println);
                start();

            }
            case 3 -> {
                Comparator c = list.get(0).getCustomComparator();
                Handler.insertionSort(list, c);
                start();
            }
            case 4 -> {
                if (!isSorted) {
                    System.out.println("Collection has not sorted");
                    start();
                }
                Comparator c = list.get(0).getCustomComparator();
                System.out.println("Your element is on "
                        + Handler.binarySearch(list, c)
                        + " position");
            }

            case 0 -> System.exit(0);

            default -> {
                System.out.println("No such option!");
                start();
            }
        }
    }

    private void driveSubmenu() {
        showCreationSubmenu();
        choose = sc.nextInt();
        list = Creator.getList(1);
        start();
    }
}