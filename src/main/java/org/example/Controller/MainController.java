package org.example.Controller;

import org.example.Model.Items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class MainController {
    ItemController itemController = new ItemController();
    StorageController storageController = new StorageController();

    public void createNewItem() {
        storageController.registerNewItem(itemController.createNewItem());
    }

    public String getItemInfo(Item item) {
        return itemController.showItemInfo(item);
    }

    public void changeItem(Item item) {
        itemController.changeItem(item);
    }

    public void addItemToSell(Item item) {
        if (!item.getAvailableToSale()) {
            itemController.makeItemAvailableToSale(item);
        }
        storageController.addItemToSell(item);
    }

    public void addItemToDrawing(Item item) {
        if (!item.getReservedForDrawing()) {
            itemController.makeItemReservedForDrawing(item);
        }
        storageController.addItemToDrawing(item);
    }

    public void makeItemUnavailable(Item item) {
        itemController.makeItemUnavailable(item);
        storageController.makeItemUnavailable(item);
    }

    public void deleteItem(Item item) {
        storageController.deleteItemFromStorage(item);

    }

    public LinkedHashMap<Integer, String> getStorageList() {
        return storageController.getStorageList();
    }

    public List<Item> getItemList(int storageChoice) {
        return storageController.getItemList(storageChoice);
    }

    public HashMap<String, Integer> getFrequencyDict (int storageChoice) {
        return storageController.getFrequencyDict(storageChoice);
    }

    public List<Item> findItem(int findItemMenuCommand, String searchingParameter) {
        List<Item> result = switch (findItemMenuCommand) {
            case 1 -> storageController.findItemById(searchingParameter);
            case 2 -> storageController.findItemByType(searchingParameter);
            case 3 -> storageController.findItemByName(searchingParameter);
            default -> new ArrayList<>();
        };
        return result;
    }
}
