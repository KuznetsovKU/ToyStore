package org.example.Model.Storages;

import org.example.Model.Items.Item;

import java.util.HashMap;

public interface StorageInterface {
    void addToStorage(Item item);
    void deleteFromStorage(Item item);
    void clearStorage();
    HashMap<String, Integer> getFrequencyDict(Storage storage);

}
