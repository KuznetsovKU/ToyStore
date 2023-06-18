package org.example.Controller;

import org.example.Model.Items.Item;
import org.example.Service.ItemService;
import org.example.View.Menus;
import org.example.View.View;

import java.util.List;

public class Program {

    MainController mc = new MainController();
    Validator validator = new Validator();
    public void startProgram() {
        importTestSample();
        View.printMenuAction(Menus.actionsMenu.get("greetings"));
        boolean programIsRunning = true;
        while (programIsRunning) {
            int mainCommand = validator.validateIntMenuChoice("mainMenu", Menus.mainMenu);
            switch (mainCommand) {
                case 1:  // "Показать склад"
                    boolean inStorageMenu = true;
                    while (inStorageMenu) {
                        int chooseStorageCommand = validator.validateIntMenuChoice("chooseStorage", mc.getStorageList());
                        if (chooseStorageCommand != 0) {
                            int showStorageCommand = validator.validateIntMenuChoice("showStorage", Menus.showStorageMenu);
                            if (showStorageCommand != 0) showStorage(chooseStorageCommand, showStorageCommand);
                        } else inStorageMenu = false;
                    }
                    continue;
                case 2:  // "Оприходовать товар"
                    mc.createNewItem();
                    View.printMenuAction(Menus.actionsMenu.get("addingSuccess"));
                    continue;
                case 3:  // "Найти товар"
                    boolean inSearchingMenu = true;
                    while (inSearchingMenu) {
                        int findItemMenuCommand = validator.validateIntMenuChoice("itemSearchingMenu", Menus.itemSearchingMenu);
                        if (findItemMenuCommand != 0) {
                            String searchingParameter = validator.validateItemNameField("chosenItemSearchingType");
                            List<Item> searchingResult = mc.findItem(findItemMenuCommand, searchingParameter);
                            while (searchingResult.size() > 1) {
                                View.printMessage(Menus.actionsMenu.get("notEmptyStorage"));
                                View.showItemList(searchingResult);
                                String specifiedChoiceCommand = validator.validateItemNameField("specifiedChoice");
                                searchingResult = mc.findItem(1, specifiedChoiceCommand);
                            }
                            if (searchingResult.size() < 1) {
                                View.printMessage(Menus.actionsMenu.get("searchingFailure"));
                            } else {
                                Item currentItem = searchingResult.get(0);
                                View.showItemInfo(mc.getItemInfo(currentItem));
                                workWithItem(currentItem);
                            }
                        } else inSearchingMenu = false;
                    }
                    continue;
                case 4:  // "Провести розыгрыш"
                    DrawingController dc = new DrawingController();
                    List<Item> alreadyDrownedItems = dc.startDrawing(mc.getItemList(3));
                    FileController fc = new FileController();
                    fc.fillFileFromList("DrawingResults", alreadyDrownedItems);
                    deleteDrownedItems(alreadyDrownedItems);
                    continue;
                case 0:  // "Завершить работу с программой"
                    View.printMenuAction(Menus.actionsMenu.get("farewell"));
                    programIsRunning = false;
                    break;
            }
        }
    }

    private void showStorage(int chooseStorageCommand, int showStorageCommand) {
        boolean inStorageShowing = true;
        while (inStorageShowing) {
            switch (showStorageCommand) {
                case 1 -> {
                    if (mc.getItemList(chooseStorageCommand).size() > 0) {
                        View.printMessage(Menus.actionsMenu.get("notEmptyStorage"));
                        View.showItemList(mc.getItemList(chooseStorageCommand));
                    } else {
                        View.printMessage(Menus.actionsMenu.get("emptyStorage"));
                    }
                    inStorageShowing = false;
                }
                case 2 -> {
                    if (mc.getFrequencyDict(chooseStorageCommand).size() > 0) {
                        View.printMessage(Menus.actionsMenu.get("notEmptyStorage"));
                        View.showFrequencyDict(mc.getFrequencyDict(chooseStorageCommand));
                    } else {
                        View.printMessage(Menus.actionsMenu.get("emptyStorage"));
                    }
                    inStorageShowing = false;
                }
            }
        }
    }

    private void workWithItem(Item item) {
        boolean inItemMenu = true;
        while (inItemMenu) {
            int itemMenuCommand = validator.validateIntMenuChoice("mainMenu", Menus.itemActionMenu);
            switch (itemMenuCommand) {
                case 1 -> View.showFullItemInfo(item);
                case 2 -> mc.changeItem(item);
                case 3 -> {
                    mc.deleteItem(item);
                    inItemMenu = false;
                }
                case 4 -> mc.makeItemUnavailable(item);
                case 5 -> mc.addItemToSell(item);
                case 6 -> mc.addItemToDrawing(item);
                case 0 -> inItemMenu = false;
            }
        }
    }

    private void importTestSample() {
        StorageController sc = new StorageController();
        ItemService is = new ItemService();
        sc.registerNewItem(is.createNewItem(2, "R2D2", 20, false, true));
        sc.registerNewItem(is.createNewItem(2, "C3PO", 20, false, true));
        sc.registerNewItem(is.createNewItem(2, "Optimus_Prime", 20, false, true));
        sc.registerNewItem(is.createNewItem(2, "Bumblebee", 20, false, true));
        sc.registerNewItem(is.createNewItem(2, "Bander", 20, false, true));
        sc.registerNewItem(is.createNewItem(1, "Lego_1", 20, false, true));
        sc.registerNewItem(is.createNewItem(1, "Lego_2", 20, false, true));
        sc.registerNewItem(is.createNewItem(1, "Lego_3", 20, false, true));
        sc.registerNewItem(is.createNewItem(1, "Lego_4", 20, false, true));
        sc.registerNewItem(is.createNewItem(1, "Lego_5", 20, false, true));
        sc.registerNewItem(is.createNewItem(3, "Barbie_1", 60, false, true));
        sc.registerNewItem(is.createNewItem(3, "Barbie_2", 60, false, true));
        sc.registerNewItem(is.createNewItem(3, "Barbie_3", 60, false, true));
        sc.registerNewItem(is.createNewItem(3, "Barbie_4", 60, false, true));
        sc.registerNewItem(is.createNewItem(3, "Barbie_5", 60, false, true));
        sc.registerNewItem(is.createNewItem(3, "Barbie_6", 60, false, true));
        sc.registerNewItem(is.createNewItem(3, "Barbie_7", 60, false, true));
        sc.registerNewItem(is.createNewItem(3, "Barbie_8", 60, false, true));
        sc.registerNewItem(is.createNewItem(3, "Barbie_9", 60, false, true));
        sc.registerNewItem(is.createNewItem(3, "Ken", 60, false, true));
    }

    private void deleteDrownedItems(List<Item> alreadyDrownedItems) {
        for (Item item : alreadyDrownedItems) {
            mc.deleteItem(item);
        }
    }

}
