package org.example.Controller;

import org.example.Model.Items.Item;
import org.example.View.ExceptionsDescriptor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileController {
    ExceptionsDescriptor exDesc = new ExceptionsDescriptor();

    public void fillFileFromList(String fileName, List<Item> itemList) {
        Path path = Path.of(fileName + ".txt");
        checkOrCreateFile(path);
        for (Item item : itemList) {
            String text = item.getShortInfo();
            try {
                Files.write(path, (text + "\n").getBytes(), StandardOpenOption.APPEND);
            } catch (FileNotFoundException e) {
                System.out.println(exDesc.MyExceptionsDescription("FileNotFoundDescription"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkOrCreateFile(Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            }
            catch (FileAlreadyExistsException e) {
                System.out.println(exDesc.MyExceptionsDescription("FileAlreadyExistsDescription"));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
