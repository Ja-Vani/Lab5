package Commands;

public class CommandAverage extends AbstactCommand {
    CommandAverage() {
        setName("average_of_impact_speed");
        setDocument("вывести среднее значение поля impactSpeed для всех элементов коллекции");
    }

    @Override
    public void execute() {
        System.out.println(CommandsExecute.getCollection().average());
    }
}
