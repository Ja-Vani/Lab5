package Commands;

public class CommandFilterImpact extends AbstactCommand {
    CommandFilterImpact() {
        setName("filter_greater_than_impact_speed");
        setDocument("вывести элементы, значение поля impactSpeed которых больше заданного");
    }

    @Override
    public void execute(String arg) {
        System.out.println(CommandsExecute.getCollection().filterImpact(Long.parseLong(arg)));
    }
}
