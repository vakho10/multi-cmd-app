package ge.edu.sangu.action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RemoveAction implements IAction {

    @Override
    public void performAction(String... args) {
        for (String fileOrFolderPath : args) {
            Path path = Paths.get(fileOrFolderPath);
            if (Files.isRegularFile(path)) {
                try {
                    Files.deleteIfExists(path);
                } catch (IOException e) {
                    System.err.println("Couldn't delete file: " + path + ", reason: " + e.getMessage());
                }
            }
        }
    }
}
