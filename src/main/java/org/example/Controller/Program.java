package org.example.Controller;

import org.example.Model.Items.Item;
import org.example.View.Menus;
import org.example.View.View;

import java.util.List;

public class Program {

    MainController mc = new MainController();
    Validator validator = new Validator();
    public void startProgram() {
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
}
