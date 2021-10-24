package Commands;

public abstract class AbstactCommand {
    private String name = "default";
    private String document = "default";

    public void execute() {
        System.out.println("Неверное количество аргументов");
    }

    public void execute(String arg) {
        System.out.println("Неверное количество аргументов");
    }

    public String getDocumentation() {
        return document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
