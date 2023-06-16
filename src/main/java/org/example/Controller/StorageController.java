package org.example.Controller;

import org.example.Model.Items.Item;
import org.example.Model.Storages.MainStorage;
import org.example.Model.Storages.StorageToDrawing;
import org.example.Model.Storages.StorageToSell;
import org.example.MyExceptions.MySaleOrDrawingAbilityException;
import org.example.View.View;

public class StorageController {
    private static final MainStorage ms = new MainStorage(1000);
    private static final StorageToSell sts = new StorageToSell(1000);
    private static final StorageToDrawing std = new StorageToDrawing(1000);
    private static final Validator validator = new Validator();

    public void registerNewItem(Item item) {
        if (item.getAvailableToSale() && !item.getReservedForDrawing()) {
            sts.addToStorage(item);
        }
        if (item.getReservedForDrawing() && !item.getAvailableToSale()) {
            std.addToStorage(item);
        }
        ms.addToStorage(item);
    }

    public void deleteItemFromStorage(Item item) {
        if (item.getAvailableToSale()) sts.deleteFromStorage(item);
        if (item.getReservedForDrawing()) std.deleteFromStorage(item);
        ms.deleteFromStorage(item);
    }

    public void addItemToSell(Item item) {
        try {
            if (validator.isAvailableToSale(item)) {
                sts.addToStorage(item);
            }
        }
        catch (MySaleOrDrawingAbilityException e) {
            View.printException(e.getMessage());
        }
    }

    public void addItemToDrawing(Item item) {
        try {
            if (validator.isReservedForDrawing(item)) {
                std.addToStorage(item);
            }
        }
        catch (MySaleOrDrawingAbilityException e) {
            View.printException(e.getMessage());
        }
    }

}
