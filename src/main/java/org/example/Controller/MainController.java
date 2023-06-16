package org.example.Controller;

import org.example.Model.Items.Item;
import org.example.View.View;

public class MainController {
    ItemController itemController = new ItemController();
    StorageController storageController = new StorageController();

    public void createNewItem() {
        storageController.registerNewItem(itemController.createNewItem());
    }

    public void showItemInfo(Item item) {
        View.showItemInfo(itemController.showItemInfo(item));
    }

    public void changeItem(Item item) {
        itemController.changeItem(item);
    }

    public void registerNewItem(Item item) {
        storageController.registerNewItem(item);
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

    private void deleteItem(Item item) {
        storageController.deleteItemFromStorage(item);

    }
}
