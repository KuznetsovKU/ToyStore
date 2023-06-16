package org.example.Controller;

import org.example.Model.Items.Item;
import org.example.Service.ItemService;
import org.example.View.Menus;


public class ItemController {
    private static final ItemService itSer = new ItemService();
    private static final Validator validator = new Validator();

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

    public String showItemInfo(Item item) {
        return itSer.getItemInfo(item);
    }

    public void changeItem(Item item) {
        int parameterToChange = validator.validateIntMenuChoice("attributeToChangeMenu", Menus.attributeToChangeMenu);
        switch (parameterToChange) {
            case 1 -> itSer.changeItemName(item, validator.validateItemNameField("name"));
            case 2 -> itSer.changeItemWinningFrequency(item, validator.validateWinningFrequency("winningFrequency"));
            case 3 -> itSer.changeItemAvailableToSale(item, validator.validateBooleanMenuChoice("availableToSale"));
            case 4 ->
                    itSer.changeItemReservedForDrawing(item, validator.validateBooleanMenuChoice("reservedForDrawing"));
            case 5 -> {
                String name = validator.validateItemNameField("name");
                int winningFrequency = validator.validateWinningFrequency("winningFrequency");
                boolean availableToSale = validator.validateBooleanMenuChoice("availableToSale");
                boolean reservedForDrawing;
                if (availableToSale) reservedForDrawing = false;
                else reservedForDrawing = validator.validateBooleanMenuChoice("reservedForDrawing");
                itSer.changeItem(item, name, winningFrequency, availableToSale, reservedForDrawing);
            }
        }

    }


}
