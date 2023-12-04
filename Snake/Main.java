import snake.Render;

public class Main {
    public static void main(String[] args) throws Exception {
        Render.clear();
        System.out.println(Render.OS);
        Render display = new Render(20, 20);
        Thread.sleep(1000);
        for (int i = 0; i < 20; i++) {
            Render.clear();
            System.out.println(display.buildDisplayString(i, 19 - i));
            Thread.sleep(500);
        }
    }
}