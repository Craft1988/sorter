package org.mike.project.utils;

public class Console {
    private Console() {
        throw new UnsupportedOperationException("unable to create an instance of this class!!");
    }

    public static void showStartMenu() {
        System.out.println(
                "1. Create collection " + '\n'
                        + "2. Show list" + '\n'
                        + "3. Sort the collection" + '\n'
                        + "4. Find element" + '\n'
                        + "0. Exit");
    }

    public static void showCreationSubmenu() {
        System.out.println(
                "1. Create a Person list" + '\n'
                        + "2. Create an Animal list" + '\n'
                        + "3. Create a Student list" + '\n'
                        + "0. Back");
    }
}
