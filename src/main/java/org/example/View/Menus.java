package org.example.View;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Menus {

    public static HashMap<String, String> menuActions = new HashMap<>();
    static {
        menuActions.put("itemTypeChoice", "Выберите тип товара");
        menuActions.put("name", "Введите наименование товара");
        menuActions.put("winningFrequency", "Укажите частоту выпадения товара в розыгрышах (в процентах)");
        menuActions.put("availableToSale", "Товар доступен к продаже?");
        menuActions.put("reservedForDrawing", "Товар участвует в розыгрыше?");
        menuActions.put("attributeToChangeMenu", "Что Вы хотите изменить в товаре?");
    }

    public static LinkedHashMap<Integer, String> itemTypesMenu = new LinkedHashMap<>();
    static {
        itemTypesMenu.put(1, "Конструктор");
        itemTypesMenu.put(2, "Робот");
        itemTypesMenu.put(3, "Кукла");
    }

    public static LinkedHashMap<Integer, String> booleanMenu = new LinkedHashMap<>();
    static {
        booleanMenu.put(1, "Да");
        booleanMenu.put(2, "Нет");
    }

    public static HashMap<String, Integer> winningFrequencyBounds = new HashMap<>();
    static {
        winningFrequencyBounds.put("min", 1);
        winningFrequencyBounds.put("max", 99);
    }

    public static LinkedHashMap<Integer, String> attributeToChangeMenu = new LinkedHashMap<>();
    static {
        attributeToChangeMenu.put(1, "Наименование товара");
        attributeToChangeMenu.put(2, "Частота выпадения в розыгрыше");
        attributeToChangeMenu.put(3, "Доступность к продаже");
        attributeToChangeMenu.put(4, "Участие в розыгрыше");
        attributeToChangeMenu.put(5, "Изменить 2 и более аттрибута");
    }

}
