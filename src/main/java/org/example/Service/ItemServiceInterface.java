package org.example.Service;

import org.example.Model.Items.Item;

public interface ItemServiceInterface {

    /**
     * Метод ручного создания экземпляра класса Item
     * @param name - наименование товара
     * @param choiceFrequency - шанс выпадения в розыгрыше
     * @param availableToSale - доступность к продаже
     * @param reservedForDrawing - нахождение в резерве для розыгрыша
     * @return Экземпляр класса Item, созданный вручную
     */
    Item createNewItem(int itemTypeChoice, String name, int choiceFrequency, boolean availableToSale, boolean reservedForDrawing);

    /**
     * Метод изменения свойств (аттрибутов) экземпляра класса Item
     * @param item - конкретный экземпляр класса Item
     */
    void changeItem(Item item);

    String getItemInfo(Item item);
}
