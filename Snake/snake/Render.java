package snake;
public class Render {
    static {
        if (System.getProperty("os.name").startsWith("Win")) {
            OS = OperatingSystem.WINDOWS;
        } else {
            OS = OperatingSystem.UNIX;
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
        int x = 0;
        int y = 0;
        StringBuilder out = new StringBuilder();
        out.append('+');
        out.append("-".repeat(Math.max(0, width)));
        out.append('+').append("\n");
        for (int i = 0; i < width; i++) {
            out.append('|');
            for (int j = 0; j < height; j++) {
                if (coordinateX == j && coordinateY == i) {
                    out.append('@');
                } else {
                    out.append(' ');
                }
            }
            out.append("|\n");
        }
        out.append('+');
        out.append("-".repeat(Math.max(0, width)));
        out.append('+');
        return out.toString();
    }
    public static void clear() throws Exception {
        String[] command;
        if (Render.OS == OperatingSystem.WINDOWS) {
            command = new String[]{"cmd", "/c", "cls"};
        } else {
            command = new String[]{"clear"};
        }
        new ProcessBuilder(command).inheritIO().start().waitFor();
    }
    public enum OperatingSystem {
        WINDOWS, UNIX
    }
}