package org.example.View;

import java.util.LinkedHashMap;

public class View {

    public static void printMenuAction(String menuAction) {
        System.out.println(menuAction);
    }

    public static void printMenu(LinkedHashMap<Integer, String> menu) {
        for (Integer key : menu.keySet())
            System.out.print(key + " : " + menu.get(key) + "     |     ");
        System.out.println();
    }

    public static void printException(String exception) {
        System.out.println(exception);
    }
}
