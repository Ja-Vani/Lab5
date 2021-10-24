package Commands;

public class CommandSave extends AbstactCommand {
    CommandSave() {
        setName("save");
        setDocument("сохранить коллекцию в файл");
    }

    @Override
    public void execute() {
        CommandsExecute.getCollection().save();
    }
}
