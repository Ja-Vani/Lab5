package Commands;

import java.util.Map;


public class CommandHelp extends AbstactCommand {

    public CommandHelp() {
        setName("help");
        setDocument("вывести справку по доступным командам");
    }

    @Override
    public void execute() {
        for (Map.Entry<String, AbstactCommand> entry : CommandsExecute.getCommands().entrySet()) {
            System.out.println(entry.getValue().getName());
            System.out.println(entry.getValue().getDocumentation());
        }
    }
}
