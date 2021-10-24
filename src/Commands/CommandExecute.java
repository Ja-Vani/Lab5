package Commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CommandExecute extends AbstactCommand {
    CommandExecute() {
        setName("execute_script");
        setDocument("считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    @Override
    public void execute(String arg) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(arg));
            while (scanner.hasNextLine()) {
                String[] cms = scanner.nextLine().split(" ");
                if (cms.length == 2 && CommandsExecute.getCommands().containsKey(cms[0])) {
                    CommandsExecute.getCommands().get(cms[0]).execute(cms[1]);
                } else if (CommandsExecute.getCommands().containsKey(cms[0])) {
                    CommandsExecute.getCommands().get(cms[0]).execute();
                } else {
                    System.out.println("Команды не существует или ошибка аргументов");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не существует, указана директория или он не может быть открыт");
            System.exit(1);
        } catch (SecurityException e) {
            System.out.println("Ошибка доступа");
            System.exit(1);
        }
    }
}
