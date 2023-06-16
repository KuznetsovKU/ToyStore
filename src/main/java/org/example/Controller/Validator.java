package org.example.Controller;

import org.example.MyExceptions.MyIllegalChoiceException;
import org.example.MyExceptions.MyNotIntegerException;
import org.example.MyExceptions.MyNullValueException;
import org.example.View.ExceptionsDescriptor;
import org.example.View.Menus;
import org.example.View.View;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class Validator {
    ExceptionsDescriptor exDesc = new ExceptionsDescriptor();

    public boolean validateBooleanMenuChoice(String menuAction) {
        boolean currentAnswer = false;
        boolean isNotValid = true;
        while (isNotValid) {
            View.printMenuAction(Menus.menuActions.get(menuAction));
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
                        throw new MyIllegalChoiceException(exDesc.MyIllegalChoiceDescription("MyIllegalChoiceException"));
                    }
                }
                catch (MyIllegalChoiceException e2) {
                    View.printException(e2.getMessage() + "");
                }
            }
            catch (MyNullValueException e1) {
                View.printException(e1.getMessage());
            }
        }
        return currentAnswer;
    }

    public int validateIntMenuChoice(String menuAction, LinkedHashMap<Integer, String> menu) {
        Integer currentCommand = null;
        boolean isNotValid = true;
        while (isNotValid) {
            View.printMenuAction(Menus.menuActions.get(menuAction));
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
                            throw new MyIllegalChoiceException(exDesc.MyIllegalChoiceDescription("MyIllegalChoiceException"));
                        }
                    }
                    catch (MyIllegalChoiceException e) {
                        View.printException(e.getMessage());
                    }
                } catch (MyNotIntegerException e) {
                    View.printException(e.getMessage());
                }
            } catch (MyNullValueException e1) {
                View.printException(e1.getMessage());
            }
        }
        return currentCommand;
    }

    public int validateWinningFrequency(String menuAction) {
        int currentWinningFrequency = -1;
        boolean isNotValid = true;
        while (isNotValid) {
            View.printMenuAction(Menus.menuActions.get(menuAction));
            String inputValue = new Scanner(System.in).next();
            try {
                inputValue = isNotNull(inputValue);
                try {
                    currentWinningFrequency = integerValidation(inputValue);
                    if (currentWinningFrequency >= 0 && currentWinningFrequency <= 100) isNotValid = false;
                    else {
                        throw new MyIllegalChoiceException(exDesc.MyIllegalChoiceDescription("MyIllegalWinningFrequencyException"));
                    }
                } catch (MyIllegalChoiceException e2) {
                    View.printException(e2.getMessage() + "");
                } catch (MyNotIntegerException e) {
                    View.printException(e.getMessage());
                }
            }
            catch (MyNullValueException e1) {
                View.printException(e1.getMessage());
            }
        }
        return currentWinningFrequency;
    }

    public String validateItemNameField(String menuAction) {
        String currentName = null;
        boolean isNotValid = true;
        while (isNotValid) {
            View.printMenuAction(Menus.menuActions.get(menuAction));
            String inputValue = new Scanner(System.in).next();
            try {
                inputValue = isNotNull(inputValue);
                currentName = inputValue;
                isNotValid = false;
            }
            catch (MyNullValueException e1) {
                View.printException(e1.getMessage());
            }
        }
        return currentName;
    }

    private int integerValidation(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        }
        catch (IllegalArgumentException e) {
            throw new MyNotIntegerException(exDesc.MyIllegalChoiceDescription("MyNotIntegerException"));
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
            throw new MyNullValueException(exDesc.MyIllegalChoiceDescription("MyNullValueException"));
        } else {
            return inputValue;
        }
    }
}
