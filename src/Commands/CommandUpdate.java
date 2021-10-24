package Commands;

public class CommandUpdate extends AbstactCommand {
    CommandUpdate() {
        setName("update");
        setDocument("обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public void execute(String arg) {
        try {
            CommandsExecute.getCollection().pushId(Long.parseLong(arg));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка аргумента");
            return;
        }
    }
}
