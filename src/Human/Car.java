package Human;

public class Car {
    private String name; //Поле не может быть null

    public Car() {
        this.name = "default";
    }

    public Car(String name) {
        if (name != null) this.name = name;
        else this.name = "default";
    }
}