package org.example.Service;

import org.example.Model.Items.Constructor;
import org.example.Model.Items.Doll;
import org.example.Model.Items.Item;
import org.example.Model.Items.Robot;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class ItemTypes {
//    protected static List<String> itemTypes = new ArrayList<>(Arrays.asList(
//            "any", "Constructor", "Robot", "Doll"));

    public static HashMap<Integer, Item> itemCreateVariants = new HashMap<>();
    static {
        itemCreateVariants.put(1, new Constructor());
        itemCreateVariants.put(2, new Robot());
        itemCreateVariants.put(3, new Doll());

    }

}
