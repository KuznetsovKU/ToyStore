package org.example;

import org.example.Service.ItemService;

public class Main {
    public static void main(String[] args) {

        ItemService itemService = new ItemService();
        System.out.println(itemService.getItemInfo(itemService.createNewItem(2, "R2D2", 20, true, false)));
        System.out.println(itemService.getItemInfo(itemService.createNewItem(2, "C3PO", 20, true, false)));
        System.out.println(itemService.getItemInfo(itemService.createNewItem(3, "Barbie", 20, true, false)));
        System.out.println(itemService.getItemInfo(itemService.createNewItem(3, "Lucy", 20, true, false)));
        System.out.println(itemService.getItemInfo(itemService.createNewItem(1, "Lego", 20, true, false)));
        System.out.println(itemService.getItemInfo(itemService.createNewItem(1, "Wood", 20, true, false)));
    }
}