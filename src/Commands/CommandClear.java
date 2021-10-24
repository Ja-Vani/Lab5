package Commands;

public class CommandClear extends AbstactCommand {
    CommandClear() {
        setName("clear");
        setDocument("очистить коллекцию");
    }

    @Override
    public void execute() {
        CommandsExecute.getCollection().clear();
    }
}
