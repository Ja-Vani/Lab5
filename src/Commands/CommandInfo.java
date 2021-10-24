package Commands;

public class CommandInfo extends AbstactCommand {
    public CommandInfo() {
        setName("info");
        setDocument("вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }

    @Override
    public void execute() {
        System.out.println(CommandsExecute.getCollection().getInfo());
    }
}
