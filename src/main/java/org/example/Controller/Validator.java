package org.example.Controller;

import org.example.Model.Items.Item;
import org.example.MyExceptions.MyIllegalChoiceException;
import org.example.MyExceptions.MyNotIntegerException;
import org.example.MyExceptions.MyNullValueException;
import org.example.MyExceptions.MySaleOrDrawingAbilityException;
import org.example.View.ExceptionsDescriptor;
import org.example.View.Menus;
import org.example.View.View;

import java.util.*;

public class Validator {
    ExceptionsDescriptor exDesc = new ExceptionsDescriptor();

    public boolean validateBooleanMenuChoice(String menuAction) {
        boolean currentAnswer = false;
        boolean isNotValid = true;
        while (isNotValid) {
            View.printMenuAction(Menus.actionsMenu.get(menuAction));
            View.printMenu(Menus.booleanMenu);
            String inputValue = new Scanner(System.in).next();
            try {
                inputValue = isNotNull(inputValue);
                try {
                    if (inputValue.equalsIgnoreCase("1") || inputValue.equalsIgnoreCase("yes") || inputValue.equalsIgnoreCase("да")) {
                        currentAnswer = true;
                        isNotValid = false;
                    } else if (inputValue.equalsIgnoreCase("2") || inputValue.equalsIgnoreCase("no") || inputValue.equalsIgnoreCase("нет")) {
                        isNotValid = false;
                    } else {
                        throw new MyIllegalChoiceException(exDesc.MyExceptionsDescription("MyIllegalChoiceException"));
                    }
                }
                catch (MyIllegalChoiceException e2) {
                    View.printMessage(e2.getMessage() + "");
                }
            }
            catch (MyNullValueException e1) {
                View.printMessage(e1.getMessage());
            }
        }
        return currentAnswer;
    }

    public int validateIntMenuChoice(String menuAction, LinkedHashMap<Integer, String> menu) {
        Integer currentCommand = null;
        boolean isNotValid = true;
        while (isNotValid) {
            View.printMenuAction(Menus.actionsMenu.get(menuAction));
            View.printMenu(menu);
            String inputValue = new Scanner(System.in).next();
            try {
                inputValue = isNotNull(inputValue);
                try {
                    currentCommand = integerValidation(inputValue);
                    try {
                        if (isContained(menu.keySet(), currentCommand)) {
                            isNotValid = false;
                        } else {
                            throw new MyIllegalChoiceException(exDesc.MyExceptionsDescription("MyIllegalChoiceException"));
                        }
                    }
                    catch (MyIllegalChoiceException e) {
                        View.printMessage(e.getMessage());
                    }
                } catch (MyNotIntegerException e) {
                    View.printMessage(e.getMessage());
                }
            } catch (MyNullValueException e1) {
                View.printMessage(e1.getMessage());
            }
        }
        return currentCommand;
    }

    public int validateWinningFrequency(String menuAction) {
        int currentWinningFrequency = -1;
        boolean isNotValid = true;
        while (isNotValid) {
            View.printMenuAction(Menus.actionsMenu.get(menuAction));
            String inputValue = new Scanner(System.in).next();
            try {
                inputValue = isNotNull(inputValue);
                try {
                    currentWinningFrequency = integerValidation(inputValue);
                    if (currentWinningFrequency >= Menus.winningFrequencyBounds.get("min") &&
                            currentWinningFrequency <= Menus.winningFrequencyBounds.get("max")) isNotValid = false;
                    else {
                        throw new MyIllegalChoiceException(exDesc.MyExceptionsDescription("MyIllegalWinningFrequencyException"));
                    }
                } catch (MyIllegalChoiceException e2) {
                    View.printMessage(e2.getMessage() + "");
                } catch (MyNotIntegerException e) {
                    View.printMessage(e.getMessage());
                }
            }
            catch (MyNullValueException e1) {
                View.printMessage(e1.getMessage());
            }
        }
        return currentWinningFrequency;
    }

    public String validateItemNameField(String menuAction) {
        String currentName = null;
        boolean isNotValid = true;
        while (isNotValid) {
            View.printMenuAction(Menus.actionsMenu.get(menuAction));
            String inputValue = new Scanner(System.in).next();
            try {
                inputValue = isNotNull(inputValue);
                currentName = inputValue;
                isNotValid = false;
            }
            catch (MyNullValueException e1) {
                View.printMessage(e1.getMessage());
            }
        }
        return currentName;
    }

    public boolean isAvailableToSale(Item item) {
        if (item.getAvailableToSale()) return true;
        else {
            throw new MySaleOrDrawingAbilityException(exDesc.MyExceptionsDescription("MyAvailableToSaleException"));
        }
    }

    public boolean isReservedForDrawing(Item item) {
        if (item.getReservedForDrawing()) return true;
        else {
            throw new MySaleOrDrawingAbilityException(exDesc.MyExceptionsDescription("MyReservedForDrawingException"));
        }
    }

    private int integerValidation(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        }
        catch (IllegalArgumentException e) {
            throw new MyNotIntegerException(exDesc.MyExceptionsDescription("MyNotIntegerException"));
        }
    }

    private boolean isContained(Set<Integer> commands, int key) {
        for (int command : commands) {
            if (command == key) return true;
        }
        return false;
    }

    private String isNotNull(String inputValue) {
        if (inputValue == null || inputValue.isEmpty()) {
            throw new MyNullValueException(exDesc.MyExceptionsDescription("MyNullValueException"));
        } else {
            return inputValue;
        }
    }

}
