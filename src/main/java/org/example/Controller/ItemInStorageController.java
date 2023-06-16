package org.example.Controller;

import org.example.Model.Items.Item;
import org.example.Model.Storages.MainStorage;
import org.example.Model.Storages.StorageToDrawing;
import org.example.Model.Storages.StorageToSell;

public class ItemInStorageController {
    MainStorage ms = new MainStorage(1000);
    StorageToSell sts = new StorageToSell(1000);
    StorageToDrawing std = new StorageToDrawing(1000);

    public void registerNewItem(Item item) {
        if (item.getAvailableToSale()) {
            sts.addToStorage(item);
        }
        if (item.getReservedForDrawing()) {
            std.addToStorage(item);
        }
        ms.addToStorage(item);
    }


}
