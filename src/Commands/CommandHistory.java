package Commands;

public class CommandHistory extends AbstactCommand {
    CommandHistory() {
        setName("history");
        setDocument("вывести последние 12 команд (без их аргументов)");
    }

    @Override
    public void execute() {
        try {
            for (int i = CommandsExecute.getList().size() - 1; i > CommandsExecute.getList().size() - 13; i--) {
                System.out.println(CommandsExecute.getList().get(i));
            }
        } catch (IndexOutOfBoundsException e) {

        }
    }
}
