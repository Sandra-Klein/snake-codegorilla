package snake;
public class Render {
    static {
        if (System.getProperty("os.name").startsWith("Win")) {
            OS = OperatingSystem.WINDOWS;
        } else {
            OS = OperatingSystem.UNIX;
        }
    }
    public static OperatingSystem OS;
    public String buildDisplayString(Snake game) {
        int x = 0;
        int y = 0;
        StringBuilder out = new StringBuilder();
        out.append("\033[").append(++y).append(";").append(x).append("H");
        out.append('+');
        out.append("-".repeat(game.gridArray[0].length));
        out.append('+');
        for (int i = 0; i < game.gridArray.length; i++) {
            out.append("\033[").append(++y).append(";").append(x).append("H");
            out.append('|');
            for (int j = 0; j < game.gridArray[0].length; j++) {
                    out.append(game.gridArray[i][j].getValue());
            }
            out.append('|');
        }
        out.append("\033[").append(++y).append(";").append(x).append("H");
        out.append('+');
        out.append("-".repeat(game.gridArray[0].length));
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