package Human;

public class Coordinates {
    private long x;
    private int y; //Максимальное значение поля: 361

    public Coordinates(long x, int y) {
        this.x = x;
        if (y <= 361) this.y = y;
        else this.y = 0;
    }

    public Coordinates() {
        this.x = 0;
        this.y = 0;
    }
}