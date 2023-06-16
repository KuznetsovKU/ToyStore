package org.example.Service;

import org.example.Model.Items.Item;

public interface ItemServiceInterface {

    /**
     * Метод ручного создания экземпляра класса Item
     * @param name - наименование товара
     * @param winningFrequency - шанс выпадения в розыгрыше
     * @param availableToSale - доступность к продаже
     * @param reservedForDrawing - нахождение в резерве для розыгрыша
     * @return Экземпляр класса Item, созданный вручную
     */
    Item createNewItem(int itemTypeChoice, String name, int winningFrequency, boolean availableToSale, boolean reservedForDrawing);

    /**
     * Метод предоставления информации об экземпляре класса Item
     * @param item - конкретный экземпляр класса Item
     * @return - Информация об экземпляре класса Item (String)
     */
    String getItemInfo(Item item);

    /**
     * Метод изменения свойств (аттрибутов) экземпляра класса Item
     * @param item - конкретный экземпляр класса Item
     */
    void changeItem(Item item, String name, int winningFrequency,
                    boolean availableToSale, boolean reservedForDrawing);

}
