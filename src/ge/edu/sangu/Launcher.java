package ge.edu.sangu;

import ge.edu.sangu.action.IAction;
import ge.edu.sangu.action.ListAction;
import ge.edu.sangu.action.MakeAction;
import ge.edu.sangu.action.RemoveAction;

import java.util.Arrays;

public class Launcher {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java -jar multi-cmd-app [command] [arguments...]");
            return;
        }
        IAction action = chooseAction(args[0]);
        if (action == null) {
            System.err.println("No such action exists!");
            return;
        }
        action.performAction(Arrays.copyOfRange(args, 1, args.length));
    }

    private static IAction chooseAction(String actionName) {
        return switch (actionName) {
            case "mk" -> new MakeAction();
            case "dir" -> new ListAction();
            case "rm" -> new RemoveAction();
        };
    }
}
