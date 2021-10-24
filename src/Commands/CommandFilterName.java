package Commands;

public class CommandFilterName extends AbstactCommand {
    CommandFilterName() {
        setName("filter_starts_with_name");
        setDocument("вывести элементы, значение поля name которых начинается с заданной подстроки");
    }

    @Override
    public void execute(String arg) {
        System.out.println(CommandsExecute.getCollection().filterName(arg));
    }
}
