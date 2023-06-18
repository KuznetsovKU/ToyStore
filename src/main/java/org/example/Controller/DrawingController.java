package org.example.Controller;

import org.example.Model.Items.Item;
import org.example.View.Menus;
import org.example.View.View;

import java.util.*;

public class DrawingController {

    Validator validator = new Validator();
    public List<Item> startDrawing(List<Item> itemList) {
        List<Item> drawingItems = prepareToDrawing(itemList);
        List<Item> alreadyDrownedItems = new LinkedList<>();
        PriorityQueue<Item> priorityQueue = new PriorityQueue<>();
//        int roundCounter = 0;
        boolean isDrawingInterrupt = false;
        firstInjection(drawingItems, priorityQueue);
        boolean drawingIsRunning = true;
        while (drawingIsRunning) {
            int drawingCommand = validator.validateIntMenuChoice("mainMenu", Menus.drawingActionMenu);
            switch (drawingCommand) {
                case 1:  // Провести раунд
                    if (priorityQueue.size() > 0) {
                        Item drownedItem = priorityQueue.poll();
                        View.printMenuAction(Menus.actionsMenu.get("drownedItem"));
                        View.showShortItemInfo(drownedItem);
                        alreadyDrownedItems.add(drownedItem);
                        nextInjection(drawingItems, priorityQueue);
//                        roundCounter++;
                    } else {
                        View.printMenuAction(Menus.actionsMenu.get("emptyDrawingList"));
                        drawingIsRunning = getDrawingResults(alreadyDrownedItems, isDrawingInterrupt);
                    }
                    continue;
                case 2: // Показать оставшиеся призы
                    List<Item> stillInDrawingList = new LinkedList<>(List.copyOf(drawingItems));
                    List<Item> stillInDrawingQueue = new LinkedList<>(priorityQueue);
                    stillInDrawingList.addAll(stillInDrawingQueue);

                    if (stillInDrawingList.size() > 0) {
                        View.printMenuAction(Menus.actionsMenu.get("itemsStillInDrawing"));
                        View.showItemList(stillInDrawingList);
                    } else {
                        View.printMenuAction(Menus.actionsMenu.get("emptyDrawingList"));
                        drawingIsRunning = getDrawingResults(alreadyDrownedItems, isDrawingInterrupt);
                    }
                    continue;
                case 0:
                    isDrawingInterrupt = true;
                    drawingIsRunning = getDrawingResults(alreadyDrownedItems, isDrawingInterrupt);
                    break;
            }
        }
        return alreadyDrownedItems;
    }

    private void firstInjection(List<Item> drawingItems, PriorityQueue<Item> priorityQueue) {
        int firstInjectionAmount = 3;
        if (drawingItems.size() > firstInjectionAmount) {
            for (int i = 0; i < firstInjectionAmount; i++) {
                int currentIndex = new Random().nextInt(drawingItems.size());
                priorityQueue.add(drawingItems.get(currentIndex));
                drawingItems.remove(currentIndex);
            }
        } else {
            priorityQueue.addAll(drawingItems);
        }
    }

    private void nextInjection(List<Item> drawingItems, PriorityQueue<Item> priorityQueue) {
        if (drawingItems.size() > 0) {
            int currentIndex = new Random().nextInt(drawingItems.size());
            priorityQueue.add(drawingItems.get(currentIndex));
            drawingItems.remove(currentIndex);
        }
    }

    private boolean getDrawingResults(List<Item> alreadyDrownedItems, boolean isDrawingInterrupt) {
        View.printMenuAction(Menus.actionsMenu.get("roundCounter") + alreadyDrownedItems.size());
        View.printMenuAction(Menus.actionsMenu.get("drownedItemList"));
        View.showItemList(alreadyDrownedItems);
        if (isDrawingInterrupt) {
            View.printMenuAction(Menus.actionsMenu.get("drawingInterrupt"));
        }
        return false;
    }

    private List<Item> prepareToDrawing(List<Item> itemList) {
        HashMap<String, List<Item>> categorisedDict = divideOnCategories(itemList);
        View.printMenuAction(Menus.actionsMenu.get("availableToDrawing"));
        for (String key : categorisedDict.keySet()) {
            for (Item item : categorisedDict.get(key)) {
                View.showShortItemInfo(item);
            }
        }

        HashMap<String, Integer> averageWinningFrequencyDict = makeAverageWinningFrequencyDict(categorisedDict);
        View.showDrawingCategoryDict(averageWinningFrequencyDict, categorisedDict);

        int roundAmount = validator.validateWinningFrequency("getRoundAmount");

        List<Item> drawingItems = fillDrawingList(categorisedDict, averageWinningFrequencyDict, roundAmount);
        View.printMenuAction(Menus.actionsMenu.get("itemsInDrawing"));
        View.showItemList(drawingItems);

        return drawingItems;
    }

    private HashMap<String, List<Item>> divideOnCategories(List<Item> itemList) {
        HashMap<String, List<Item>> categorisedDict = new HashMap<>();
        for (Item item : itemList) {
            String currentKey = item.getItemType();
            if (!categorisedDict.containsKey(currentKey)) {
                categorisedDict.put(currentKey, new LinkedList<>());
            }
            categorisedDict.get(currentKey).add(item);
        }
        return categorisedDict;
    }

    private HashMap<String, Integer> makeAverageWinningFrequencyDict(HashMap<String, List<Item>> categorisedDict) {
        HashMap<String, Integer> averageWinningFrequencyDict = new HashMap<>();
        for (String key : categorisedDict.keySet()) {
            int itemAmount = categorisedDict.get(key).size();
            int sumWF = 0;
            for (Item item : categorisedDict.get(key)) {
                sumWF += item.getWinningFrequency();
            }
            averageWinningFrequencyDict.put(key, sumWF / itemAmount);
        }
        return averageWinningFrequencyDict;
    }

    private List<Item> fillDrawingList(HashMap<String, List<Item>> categorisedDict,
                                       HashMap<String, Integer> averageWinningFrequencyDict, int roundAmount) {

        List<Item> drawingList = new ArrayList<>();
        for (String key : categorisedDict.keySet()) {
            List<Item> currentCategory = categorisedDict.get(key);
            int itemsAmount = roundAmount * averageWinningFrequencyDict.get(key) / 100;
            for (int i = 0; i < itemsAmount; i++) {
                drawingList.add(currentCategory.get(0));
                currentCategory.remove(0);
            }
        }
        while (drawingList.size() < roundAmount) {
            int difference = roundAmount - drawingList.size();
            int maxAWF = 0;
            String maxAWFKey = null;
            for (String key : averageWinningFrequencyDict.keySet()) {
                if (averageWinningFrequencyDict.get(key) > maxAWF && categorisedDict.get(key).size() > 0) {
                    maxAWF = averageWinningFrequencyDict.get(key);
                    maxAWFKey = key;
                }
            }
            for (int i = 0; i < difference; i++) {
                drawingList.add(categorisedDict.get(maxAWFKey).get(0));
                categorisedDict.get(maxAWFKey).remove(0);
            }
        }
        return drawingList;
    }

}
