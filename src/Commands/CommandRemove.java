package Commands;

public class CommandRemove extends AbstactCommand {
    CommandRemove() {
        setName("remove_key");
        setDocument("удалить элемент из коллекции по его ключу");
    }

    @Override
    public void execute(String arg) {
        try {
            Integer i = Integer.parseInt(arg);
            CommandsExecute.getCollection().remove(i);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка аргумента");
            return;
        }
    }
}
