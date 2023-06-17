package org.example;

import org.example.Controller.ItemController;
import org.example.Controller.Program;
import org.example.Model.Items.Item;
import org.example.Service.ItemService;
import org.example.View.Menus;
import org.example.View.View;

public class Main {
    public static void main(String[] args) {

//        ItemService itemService = new ItemService();
//        System.out.println(itemService.getItemInfo(itemService.createNewItem(2, "R2D2", 20, true, false)));
//        System.out.println(itemService.getItemInfo(itemService.createNewItem(2, "C3PO", 20, true, false)));
//        System.out.println(itemService.getItemInfo(itemService.createNewItem(3, "Barbie", 20, true, false)));
//        System.out.println(itemService.getItemInfo(itemService.createNewItem(3, "Lucy", 20, true, false)));
//        System.out.println(itemService.getItemInfo(itemService.createNewItem(1, "Lego", 20, true, false)));
//        System.out.println(itemService.getItemInfo(itemService.createNewItem(1, "Wood", 20, true, false)));
//
//        View.printMenu(Menus.itemTypesMenu);

//        ItemController itemController = new ItemController();
//        Item item = itemController.createNewItem();
//        System.out.println(item);

        Program program = new Program();
        program.startProgram();
    }
}