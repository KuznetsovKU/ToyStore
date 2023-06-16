package org.example.Controller;

import org.example.Model.Items.Item;
import org.example.Service.ItemService;
import org.example.View.Menus;
import org.example.View.View;


public class ItemController {
    ItemService itSer = new ItemService();
    Validator validator = new Validator();

    public Item createNewItem() {
        int itemTypeChoice = validator.validateIntMenuChoice("itemTypeChoice", Menus.itemTypesMenu);
        String name = validator.validateItemNameField("name");
        int winningFrequency = validator.validateWinningFrequency("winningFrequency");
        boolean availableToSale = validator.validateBooleanMenuChoice("availableToSale");
        boolean reservedForDrawing;

        if (availableToSale) reservedForDrawing = false;
        else reservedForDrawing = validator.validateBooleanMenuChoice("reservedForDrawing");

        return itSer.createNewItem(itemTypeChoice, name, winningFrequency, availableToSale, reservedForDrawing);
    }

    public String getItemInfo(Item item) {
        return itSer.getItemInfo(item);
    }

//    private void printMenuActions(String menuAction) {
//        View.printMenuAction(Menus.menuActions.get(menuAction));
//    }



}
