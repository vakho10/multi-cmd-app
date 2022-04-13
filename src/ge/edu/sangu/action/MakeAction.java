package ge.edu.sangu.action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MakeAction implements IAction {

    @Override
    public void performAction(String... args) {
        for (String dirOrFilePath : args) {
            Path path = Paths.get(dirOrFilePath);
            if (Files.isRegularFile(path)) {
                try {
                    Files.createFile(path);
                } catch (IOException e) {
                    System.err.println("Error while creating file: " + path + ", reason: " + e.getMessage());
                }
            }
        }
    }
}




