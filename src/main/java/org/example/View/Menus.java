package org.example.View;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Menus {

    public static LinkedHashMap<Integer, String> mainMenu = new LinkedHashMap<>();
    static {
        mainMenu.put(1, "Показать склад");
        mainMenu.put(2, "Оприходовать товар");
        mainMenu.put(3, "Найти товар");
        mainMenu.put(4, "Провести розыгрыш");
        mainMenu.put(0, "Завершить работу с программой");
    }

    public static LinkedHashMap<Integer, String> showStorageMenu = new LinkedHashMap<>();
    static {
        showStorageMenu.put(1, "Показать все товары на складе");
        showStorageMenu.put(2, "Показать количество товаров по категориям");
        showStorageMenu.put(0, "Возврат к предыдущему меню");
    }

    public static LinkedHashMap<Integer, String> itemSearchingMenu = new LinkedHashMap<>();
    static {
        itemSearchingMenu.put(1, "По ID товара");
        itemSearchingMenu.put(2, "По типу товара");
        itemSearchingMenu.put(3, "По наименованию товара");
        itemSearchingMenu.put(0, "Возврат к предыдущему меню");
    }

    public static LinkedHashMap<Integer, String> itemActionMenu = new LinkedHashMap<>();
    static {
        itemActionMenu.put(1, "Показать информацию о товаре.");
        itemActionMenu.put(2, "Изменить параметры товара.");
        itemActionMenu.put(3, "Продать товар.");
        itemActionMenu.put(4, "Снять товар с продажи и розыгрышей.");
        itemActionMenu.put(5, "Поместить товар в продажу.");
        itemActionMenu.put(6, "Передать товар в розыгрыш.");
        itemActionMenu.put(0, "Возврат к предыдущему меню");
    }

    public static HashMap<String, String> actionsMenu = new HashMap<>();
    static {
        actionsMenu.put("greetings", "Добро пожаловать в магазин игрушек!");
        actionsMenu.put("farewell", "Работа программы завершена. До свидания!");
        actionsMenu.put("mainMenu", "Выберите нужный пункт меню");

        actionsMenu.put("itemTypeChoice", "Выберите тип товара");
        actionsMenu.put("name", "Введите наименование товара");
        actionsMenu.put("winningFrequency", "Укажите частоту выпадения товара в розыгрышах (в процентах)");
        actionsMenu.put("availableToSale", "Товар доступен к продаже?");
        actionsMenu.put("reservedForDrawing", "Товар участвует в розыгрыше?");

        actionsMenu.put("attributeToChangeMenu", "Что Вы хотите изменить в товаре?");

        actionsMenu.put("chooseStorage", "Какой склад Вы хотите посмотреть?");
        actionsMenu.put("showStorage", "Какую информацию отобразить?");

        actionsMenu.put("itemSearchingMenu", "По какому параметру будем искать?");
        actionsMenu.put("chosenItemSearchingType", "Введите соответствующую информацию для поиска ");
        actionsMenu.put("emptyStorage", "К сожалению, склад пуст.");
        actionsMenu.put("notEmptyStorage", "Найдены следующие позиции.");
        actionsMenu.put("searchingFailure", "К сожалению, по запросу ничего не найдено.");
        actionsMenu.put("specifiedChoice", "Укажите нужный ID из предложенного списка.");
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
        attributeToChangeMenu.put(0, "Возврат к предыдущему меню");
    }

}
