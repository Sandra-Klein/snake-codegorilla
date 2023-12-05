package snake;
import java.io.IOException;
public class Render {
    static {
        switch (System.getProperty("os.name")) {
            case "Linux":
                OS = OperatingSystem.LINUX;
                break;
            case "Windows":
                OS = OperatingSystem.WINDOWS;
                break;
        }
    }
    public int width;
    public int height;
    public static OperatingSystem OS;
    public Render(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public String buildDisplayString(int coordinateX, int coordinateY) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (coordinateX == j && coordinateY == i) {
                    out.append('@');
                } else {
                    out.append('.');
                }
            }
            out.append("\n");
        }
        return out.toString();
    }
    public static void clear() throws IOException {
        if (Render.OS == OperatingSystem.LINUX) {
            // String cmd = "clear";
            // Runtime.getRuntime().exec(cmd);
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } else {
            Runtime.getRuntime().exec("cls");
        }
    }
    public enum OperatingSystem {
        WINDOWS, LINUX
    }
}