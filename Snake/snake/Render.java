package snake;
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
    public static void clear() throws Exception {
        String[] command;
        if (Render.OS == OperatingSystem.LINUX) {
            command = new String[]{"clear"};
        } else {
            command = new String[]{"cmd", "/c", "cls"};
        }
        new ProcessBuilder(command).inheritIO().start().waitFor();
    }
    public enum OperatingSystem {
        WINDOWS, LINUX
    }
}