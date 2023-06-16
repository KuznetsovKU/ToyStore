package org.example.Service;

import org.example.Model.Items.Constructor;
import org.example.Model.Items.Doll;
import org.example.Model.Items.Item;
import org.example.Model.Items.Robot;

public class ItemService implements ItemServiceInterface{

    @Override
    public Item createNewItem(int itemTypeChoice, String name, int winningFrequency,
                              boolean availableToSale, boolean reservedForDrawing) {
//        Item newItem = ItemTypes.itemCreateVariants.get(itemTypeChoice);
//        newItem.setName(name);
//        newItem.setWinningFrequency(winningFrequency);
//        newItem.setAvailableToSale(availableToSale);
//        newItem.setReservedForDrawing(reservedForDrawing);
//        return newItem;
        return switch (itemTypeChoice) {
            case 1 -> new Constructor(name, winningFrequency, availableToSale, reservedForDrawing);
            case 2 -> new Robot(name, winningFrequency, availableToSale, reservedForDrawing);
            case 3 -> new Doll(name, winningFrequency, availableToSale, reservedForDrawing);
            default -> null;
        };
    }

    @Override
    public void changeItem(Item item) {

    }

    @Override
    public String getItemInfo(Item item) {
        return item.toString();
    }
}
