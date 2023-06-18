package org.example.View;

import java.util.HashMap;

public class ExceptionsDescriptor {

    private static final HashMap<String, String> exceptionsDescription = new HashMap<>();
    static {
        exceptionsDescription.put("MyIllegalChoiceException", "Ошибка обработки команды. Проверьте выбор действия и попробуйте снова.");
        exceptionsDescription.put("MyNotIntegerException", "Введенное значение не является числом.");
        exceptionsDescription.put("MyNullValueException", "Аргумент не был передан.");
        exceptionsDescription.put("MyIllegalWinningFrequencyException", "Некорректное значение. Должно быть от 0 до 100");
        exceptionsDescription.put("MyAvailableToSaleException", "Товар участвует в розыгрыше и не может быть продан.");
        exceptionsDescription.put("MyReservedForDrawingException", "Товар находится в продаже и не может участвовать в розыгрыше.");
        exceptionsDescription.put("MyValueNotFoundException", "Товар(ы) с указанными характеристиками не найдены. Проверьте введенные данные и повторите поиск.");
        exceptionsDescription.put("FileAlreadyExistsDescription", "Файл уже существует.");
        exceptionsDescription.put("FileNotFoundDescription", "Файл не найден.");
    }

    public String MyExceptionsDescription(String exceptionType) {
        return exceptionsDescription.get(exceptionType);
    }
}
