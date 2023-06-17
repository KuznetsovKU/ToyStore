package org.example.View;

import org.example.Model.Items.Item;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class View {

    public static void printMenuAction(String menuAction) {
        System.out.println(menuAction);
    }

    public static void printMenu(LinkedHashMap<Integer, String> menu) {
        for (Integer key : menu.keySet())
            System.out.print(key + " : " + menu.get(key) + "     |     ");
        System.out.println();
    }

    public static void printMessage(String exception) {
        System.out.println(exception);
    }

    public static void showItemInfo(String itemInfo) {
        System.out.println(itemInfo);
    }

    public static void showFullItemInfo(Item item) {
        String name = "Наименование товара";
        String type = "Тип товара";
        String id = "ID товара";
        String winningFrequency = "Частота выпадения в розыгрыше";
        String availableToSale = "Доступность товара к продаже";
        String reservedForDrawing = "Участие товара в розыгрыше";
        System.out.println(name + spaceBuilder(name) + ": " + item.getName());
        System.out.println(type + spaceBuilder(type) + ": " + item.getItemType());
        System.out.println(id + spaceBuilder(id) + ": " + item.getId());
        System.out.println(winningFrequency + spaceBuilder(winningFrequency) + ": " + item.getWinningFrequency());
        System.out.println(availableToSale + spaceBuilder(availableToSale) + ": " + item.getAvailableToSale());
        System.out.println(reservedForDrawing + spaceBuilder(reservedForDrawing) + ": " + item.getReservedForDrawing());
    }

    public static void showItemList(List<Item> itemList) {
        for (Item item : itemList) {
            showItemInfo(item.toString());
        }
        System.out.println();
    }

    public static void showFrequencyDict(HashMap<String, Integer> frequencyDict) {
        for (String key : frequencyDict.keySet()) {
            System.out.println(key + spaceBuilder(key) + ": " + frequencyDict.get(key));
        }
    }

    private static String spaceBuilder(String inputValue) {
        String baseSting = "                              ";
        return baseSting.substring(0, baseSting.length() - inputValue.length());
    }

}
