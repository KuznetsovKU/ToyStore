package org.example.Controller;

import org.example.Model.Items.Item;
import org.example.Model.Storages.MainStorage;
import org.example.Model.Storages.StorageToDrawing;
import org.example.Model.Storages.StorageToSell;
import org.example.MyExceptions.MySaleOrDrawingAbilityException;
import org.example.View.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class StorageController {
    private static final MainStorage ms = new MainStorage(1000);
    private static final StorageToSell sts = new StorageToSell(1000);
    private static final StorageToDrawing std = new StorageToDrawing(1000);
    private static final Validator validator = new Validator();

    private static final LinkedHashMap<Integer, String> storageList = new LinkedHashMap<>();
    static {
        storageList.put(1, ms.getStorageType());
        storageList.put(2, sts.getStorageType());
        storageList.put(3, std.getStorageType());
        storageList.put(0, "Возврат к предыдущему меню");
    }

    public LinkedHashMap<Integer, String> getStorageList() {
        return storageList;
    }

    public List<Item> getItemList(int storageChoice) {
        return switch (storageChoice) {
            case 1 -> ms.getItemList();
            case 2 -> sts.getItemList();
            case 3 -> std.getItemList();
            default -> null;
        };
    }

    public HashMap<String, Integer> getFrequencyDict (int storageChoice) {
        return switch (storageChoice) {
            case 1 -> ms.getFrequencyDict();
            case 2 -> sts.getFrequencyDict();
            case 3 -> std.getFrequencyDict();
            default -> null;
        };
    }

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
            View.printMessage(e.getMessage());
        }
    }

    public void addItemToDrawing(Item item) {
        try {
            if (validator.isReservedForDrawing(item)) {
                std.addToStorage(item);
            }
        }
        catch (MySaleOrDrawingAbilityException e) {
            View.printMessage(e.getMessage());
        }
    }

    public void makeItemUnavailable(Item item) {
        sts.deleteFromStorage(item);
        std.deleteFromStorage(item);
    }

    public List<Item> findItemById(String parameter) {
        List<Item> result = new ArrayList<>();
        String baseIdNum = "00000000";
        String requestedId = baseIdNum.substring(0, baseIdNum.length() - parameter.length()) + parameter;
        for (Item item : ms.getItemList()) {
            if (item.getId().equalsIgnoreCase(requestedId)) result.add(item);
        }
        return result;
    }

    public List<Item> findItemByName(String parameter) {
        List<Item> result = new ArrayList<>();
        for (Item item : ms.getItemList()) {
            if (item.getName().equalsIgnoreCase(parameter)) result.add(item);
        }
        return result;
    }

    public List<Item> findItemByType(String parameter) {
        List<Item> result = new ArrayList<>();
        for (Item item : ms.getItemList()) {
            if (item.getItemType().equalsIgnoreCase(parameter)) result.add(item);
        }
        return result;
    }
}
