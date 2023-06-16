package org.example.Model.Storages;

import org.example.Model.Items.Item;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class StorageToDrawing extends Storage{
    protected List<Item> itemList = new LinkedList<>();
    public StorageToDrawing(int capacity) {
        super(capacity);
    }

    @Override
    public void addToStorage(Item item) {
        this.itemList.add(item);
    }

    @Override
    public void deleteFromStorage(Item item) {
        this.itemList.remove(item);
    }

    @Override
    public void clearStorage() {
        this.itemList.clear();
    }

    @Override
    public List<Item> getItemList() {
        return itemList;
    }

    @Override
    public HashMap<String, Integer> getFrequencyDict(Storage storage) {
        HashMap<String, Integer> frequencyDict = new HashMap<>();
        for (Item item : this.itemList) {
            String type = item.getItemType();
            frequencyDict.put(type, frequencyDict.getOrDefault(type, 0) + 1);
        }
        return frequencyDict;
    }

}
