package Commands;

import Human.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CommandsExecute {
    private static Collection collection;
    private static HashMap<String, AbstactCommand> commands = new HashMap<String, AbstactCommand>();
    private static ArrayList<String> list = new ArrayList<String>();

    public CommandsExecute(Collection collection) {
        this.collection = collection;
        createCommand();
    }

    public void createCommand() {
        CommandInsert insert = new CommandInsert();
        commands.put(insert.getName(), insert);
        CommandInfo info = new CommandInfo();
        commands.put(info.getName(), info);
        CommandShow show = new CommandShow();
        commands.put(show.getName(), show);
        CommandUpdate update = new CommandUpdate();
        commands.put(update.getName(), update);
        CommandRemove remove = new CommandRemove();
        commands.put(remove.getName(), remove);
        CommandClear clear = new CommandClear();
        commands.put(clear.getName(), clear);
        CommandSave save = new CommandSave();
        commands.put(save.getName(), save);
        CommandExecute execute = new CommandExecute();
        commands.put(execute.getName(), execute);
        CommandHistory history = new CommandHistory();
        commands.put(history.getName(), history);
        CommandReplace replace = new CommandReplace();
        commands.put(replace.getName(), replace);
        CommandAverage average = new CommandAverage();
        commands.put(average.getName(), average);
        CommandFilterImpact impact = new CommandFilterImpact();
        commands.put(impact.getName(), impact);
        CommandFilterName name = new CommandFilterName();
        commands.put(name.getName(), name);
        CommandExit exit = new CommandExit();
        commands.put(exit.getName(), exit);
        CommandHelp help = new CommandHelp();
        commands.put(help.getName(), help);
    }

    public void run(String name) {
        String[] cms = name.split(" ");
        if (cms.length == 2 && commands.containsKey(cms[0])) {
            commands.get(cms[0]).execute(cms[1]);
        } else if (commands.containsKey(cms[0])) {
            commands.get(cms[0]).execute();
        } else {
            System.out.println("Команды не существует или ошибка аргументов");
        }
        list.add(name);
    }

    public static Collection getCollection() {
        return collection;
    }

    public static HashMap<String, AbstactCommand> getCommands() {
        return commands;
    }

    public static ArrayList<String> getList() {
        return list;
    }

}
