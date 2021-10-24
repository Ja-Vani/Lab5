package Commands;

public class CommandShow extends AbstactCommand {
    CommandShow() {
        setName("show");
        setDocument("вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    @Override
    public void execute() {
        System.out.println(CommandsExecute.getCollection().getElements());
    }
}
