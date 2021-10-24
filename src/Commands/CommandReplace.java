package Commands;

public class CommandReplace extends AbstactCommand {
    CommandReplace() {
        setName("replace_if_lowe");
        setDocument("заменить значение по ключу, если новое значение меньше старого");
    }

    @Override
    public void execute(String arg) {
        try {
            Integer i = Integer.parseInt(arg);
            CommandsExecute.getCollection().ril(i);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка аргумента");
        }
    }
}
