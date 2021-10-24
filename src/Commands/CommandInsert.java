package Commands;

public class CommandInsert extends AbstactCommand {
    public CommandInsert() {
        setName("insert");
        setDocument("добавить новый элемент с заданным ключом");
    }

    @Override
    public void execute(String arg) {
        try {
            Integer i = Integer.parseInt(arg);
            CommandsExecute.getCollection().insert(i);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка аргумента");
        }
    }
}
