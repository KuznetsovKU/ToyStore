package org.example.Model.Storages;

import org.example.Model.Items.Item;

import java.util.LinkedList;
import java.util.List;

public abstract class Storage implements StorageInterface {

    protected String storageType;
    protected int capacity;
    protected List<Item> itemList = new LinkedList<>();

    public Storage(int capacity) {
        this.storageType = this.getClass().getSimpleName();
        this.capacity = capacity;
    }

    public String getStorageType() {
        return storageType;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Item> getItemList() {
        return itemList;
    }

}
