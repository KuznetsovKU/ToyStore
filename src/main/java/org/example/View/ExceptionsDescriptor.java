package org.example.View;

import java.util.HashMap;

public class ExceptionsDescriptor {

    private static HashMap<String, String> exceptionsDescription = new HashMap<>();
    static {
        exceptionsDescription.put("MyIllegalChoiceException", "Ошибка обработки команды. Проверьте выбор действия и попробуйте снова.");
        exceptionsDescription.put("MyNotIntegerException", "Введенное значение не является числом.");
        exceptionsDescription.put("MyNullValueException", "Аргумент не был передан.");
        exceptionsDescription.put("MyIllegalWinningFrequencyException", "Некорректное значение. Должно быть от 0 до 100");
    }

    public String MyIllegalChoiceDescription(String exceptionType) {
        return exceptionsDescription.get(exceptionType);
    }
}
