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
    public String buildDisplayString(Game game) {
        StringBuilder out = new StringBuilder();
        out.append('+');
        out.append("-".repeat(game.gridArray[0].length));
        out.append('+').append("\n");
        for (int i = 0; i < game.gridArray.length; i++) {
            out.append('|');
            for (int j = 0; j < game.gridArray[0].length; j++) {
                    out.append(game.gridArray[i][j]);
            }
            out.append("|\n");
        }
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