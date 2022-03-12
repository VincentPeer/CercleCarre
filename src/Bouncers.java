import world.WorldView;

public class Bouncers {
    public static void main(String ... args) {
        MainWindow mainW = new MainWindow();
        mainW.setTitle("Bouncers");
        mainW.add(new WorldView(600, 600, 50));
    }
}
