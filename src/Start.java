import Commands.*;
import Human.*;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandsExecute commandsExecute;
        try {
            Collection collection = new Collection(args[0]);
            CommandsExecute c = new CommandsExecute(collection);
            commandsExecute = c;
        } catch (ArrayIndexOutOfBoundsException e) {
            Collection collection = new Collection("def");
            CommandsExecute c = new CommandsExecute(collection);
            commandsExecute = c;
        }
        while(scanner.hasNextLine()){
            commandsExecute.run(scanner.nextLine());
        }
    }
}
