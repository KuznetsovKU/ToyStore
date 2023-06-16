package org.example.Service;

import org.example.Model.Items.Constructor;
import org.example.Model.Items.Doll;
import org.example.Model.Items.Item;
import org.example.Model.Items.Robot;

public class ItemService implements ItemServiceInterface{

    @Override
    public Item createNewItem(int itemTypeChoice, String name, int winningFrequency,
                              boolean availableToSale, boolean reservedForDrawing) {
        return switch (itemTypeChoice) {
            case 1 -> new Constructor(name, winningFrequency, availableToSale, reservedForDrawing);
            case 2 -> new Robot(name, winningFrequency, availableToSale, reservedForDrawing);
            case 3 -> new Doll(name, winningFrequency, availableToSale, reservedForDrawing);
            default -> null;
        };
    }

    @Override
    public String getItemInfo(Item item) {
        return item.toString();
    }

    @Override
    public void changeItem(Item item, String name, int winningFrequency,
                           boolean availableToSale, boolean reservedForDrawing) {
        changeItemName(item, name);
        changeItemWinningFrequency(item, winningFrequency);
        changeItemAvailableToSale(item, availableToSale);
        changeItemReservedForDrawing(item, reservedForDrawing);
    }

    public void changeItemName(Item item, String name) {
        item.setName(name);
    }

    public void changeItemWinningFrequency(Item item, int winningFrequency) {
        item.setWinningFrequency(winningFrequency);
    }

    public void changeItemAvailableToSale(Item item, boolean availableToSale) {
        item.setAvailableToSale(availableToSale);
    }
    public void changeItemReservedForDrawing(Item item, boolean reservedForDrawing) {
        item.setAvailableToSale(reservedForDrawing);
    }

}
