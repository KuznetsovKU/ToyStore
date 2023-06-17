package org.example.Model.Storages;

import org.example.Model.Items.Item;

import java.util.HashMap;
import java.util.List;

public interface StorageInterface {
    void addToStorage(Item item);
    void deleteFromStorage(Item item);
    void clearStorage();

    List<Item> getItemList();

    HashMap<String, Integer> getFrequencyDict();

}
