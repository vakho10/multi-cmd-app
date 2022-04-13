package ge.edu.sangu.action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class ListAction implements IAction {

    @Override
    public void performAction(String... args)  {
        for (String dirOrFilePath : args) {
            Path path = Paths.get(dirOrFilePath);
            if (Files.isDirectory(path)) {
                try {
                    for (Path entry : Files.list(path).toList()) {
                        System.out.println(entry);
                    }
                } catch (IOException e) {
                    System.err.println("Error listing directory: " + path + ", reason: " + e.getMessage());
                }
            }
        }
    }


}
