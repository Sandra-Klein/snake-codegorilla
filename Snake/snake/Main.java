package snake;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws Exception {
        Main.mainMenu();
        System.in.read();
        Input input = new Input();
        Snake snakeGame = new Snake(new Coordinate(9, 9));
        Render display = new Render();
        Render.clear();
        Main.gameStart();
        sleep(1500);
        if (display.OS != Render.OperatingSystem.WINDOWS) {
            String[] cmdInsane = {"/bin/sh", "-c", "stty raw </dev/tty"};
            Runtime.getRuntime().exec(cmdInsane).waitFor();
        }
        input.startGame();
        try {
            while (input.gameStarted) {
                input.getUserInput();
                snakeGame.setCurrentDir(input.lastDirection);
                if (input.currentInput == GameAction.GAME_QUIT) {
                    input.gameStarted = false;
                }
                Render.clear();
                snakeGame.move();
                snakeGame.updateGrid();
                System.out.println(display.buildDisplayString(snakeGame));
            }
        } catch (Exception e) {
            if (display.OS != Render.OperatingSystem.WINDOWS) {
                String[] cmdSane = {"/bin/sh", "-c", "stty sane </dev/tty"};
                Runtime.getRuntime().exec(cmdSane).waitFor();
            }
            Main.gameOver();
            sleep(1500);
            Render.clear();
            Main.gameCredits();
        }
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLACK = "\u001B[30m";
    static void gameCredits() {
        System.out.println(" ______________________________________________________" );
        System.out.println("|" + ANSI_RED + " ██████╗██████╗ ███████╗██████╗ ██╗████████╗███████╗   "+ ANSI_RESET + "|");
        System.out.println("|" + ANSI_RED + "██╔════╝██╔══██╗██╔════╝██╔══██╗██║╚══██╔══╝██╔════╝██╗"+ ANSI_RESET+ "|");
        System.out.println("|" + ANSI_RED + "██║     ██████╔╝█████╗  ██║  ██║██║   ██║   ███████╗╚═╝"+ ANSI_RESET+ "|");
        System.out.println("|" + ANSI_RED + "██║     ██╔══██╗██╔══╝  ██║  ██║██║   ██║   ╚════██║██╗"+ ANSI_RESET+ "|");
        System.out.println("|" + ANSI_RED + "╚██████╗██║  ██║███████╗██████╔╝██║   ██║   ███████║╚═╝"+ ANSI_RESET+ "|");
        System.out.println("|" + ANSI_RED + " ╚═════╝╚═╝  ╚═╝╚══════╝╚═════╝ ╚═╝   ╚═╝   ╚══════╝   "+ ANSI_RESET+ "|");
        System.out.println("|" + ANSI_BLUE +   "╔═╗╦═╗╔╗╔╔═╗╔╦╗                                        "+ ANSI_RESET+ "|");
        System.out.println("|" + ANSI_BLUE+    "║╣ ╠╦╝║║║╚═╗ ║                                         "+ ANSI_RESET+ "|");
        System.out.println("|" + ANSI_BLUE +   "╚═╝╩╚═╝╚╝╚═╝ ╩                                         "+ ANSI_RESET+ "|");
        System.out.println("|" + ANSI_YELLOW+  " ╦╔═╗╔╗╔                                               "+ ANSI_RESET+ "|");
        System.out.println("|" + ANSI_YELLOW + " ║╠═╣║║║                                               "+ ANSI_RESET+ "|");
        System.out.println("|" + ANSI_YELLOW + "╚╝╩ ╩╝╚╝                                               "+ ANSI_RESET+ "|");
        System.out.println("|" + ANSI_GREEN +  "╔═╗╔═╗╔╗╔╔╦╗╦═╗╔═╗                                     "+ ANSI_RESET+ "|");
        System.out.println("|" + ANSI_GREEN +  "╚═╗╠═╣║║║ ║║╠╦╝╠═╣                                     "+ ANSI_RESET+ "|");
        System.out.println("|" + ANSI_GREEN +  "╚═╝╩ ╩╝╚╝═╩╝╩╚═╩ ╩                                     "+ ANSI_RESET+ "|");
        System.out.println(" ______________________________________________________");
    }
    static void gameStart() {
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_GREEN+ " __________________________________________" + ANSI_RESET);
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_GREEN+ "| ███████ ████████  █████  ██████  ████████ |" + ANSI_RESET);
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_GREEN+ "| ██         ██    ██   ██ ██   ██    ██    |" + ANSI_RESET);
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_GREEN+ "| ███████    ██    ███████ ██████     ██    |" + ANSI_RESET);
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_GREEN+ "|      ██    ██    ██   ██ ██   ██    ██    |" + ANSI_RESET);
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_GREEN+ "| ███████    ██    ██   ██ ██   ██    ██    |" + ANSI_RESET);
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_GREEN+ "|                                           |" + ANSI_RESET);
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_GREEN+ "|                                           |" + ANSI_RESET);
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_GREEN+ "|  ██████   █████  ███    ███ ███████       |" + ANSI_RESET);
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_GREEN+ "| ██       ██   ██ ████  ████ ██            |" + ANSI_RESET);
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_GREEN+ "| ██   ███ ███████ ██ ████ ██ █████         |" + ANSI_RESET);
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_GREEN+ "| ██    ██ ██   ██ ██  ██  ██ ██            |" + ANSI_RESET);
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_GREEN+ "|  ██████  ██   ██ ██      ██ ███████       |" + ANSI_RESET);
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_GREEN+ " ___________________________________________" + ANSI_RESET);
    }

    static void gameOver() {
        System.out.println("  ------------------------------------------------- ");
        System.out.println("|" + ANSI_GREEN +"  /$$$$$$                                         "+ ANSI_RESET + "|");
        System.out.println("|" + ANSI_GREEN +" /$$__  $$                                        "+ ANSI_RESET + "|");
        System.out.println("|" + ANSI_GREEN +"| $$   __/  /$$$$$$  /$$$$$$/$$$$   /$$$$$$       "+ ANSI_RESET + "|");
        System.out.println("|" + ANSI_GREEN +"| $$ /$$$$ |____  $$| $$_  $$_  $$ /$$__  $$      "+ ANSI_RESET + "|");
        System.out.println("|" + ANSI_GREEN +"| $$|_  $$  /$$$$$$$| $$   $$   $$| $$$$$$$$      "+ ANSI_RESET + "|");
        System.out.println("|" + ANSI_GREEN +"| $$    $$ /$$__  $$| $$ | $$ | $$| $$_____/      "+ ANSI_RESET + "|");
        System.out.println("|" + ANSI_GREEN +"|  $$$$$$/|  $$$$$$$| $$ | $$ | $$|  $$$$$$$      "+ ANSI_RESET + "|");
        System.out.println("|" + ANSI_GREEN +"  ______/    _______/|__/ |__/ |__/  _______/     "+ ANSI_RESET + "|");
        System.out.println("|                                                  |");
        System.out.println("|                                                  |");
        System.out.println("|" + ANSI_GREEN +"  /$$$$$$  /$$    /$$  /$$$$$$   /$$$$$$          "+ ANSI_RESET + "|");
        System.out.println("|" + ANSI_GREEN +" /$$__  $$|  $$  /$$/ /$$__  $$ /$$__  $$         "+ ANSI_RESET + "|");
        System.out.println("|" + ANSI_GREEN +"| $$  \\ $$ \\  $$/$$/ | $$$$$$$$| $$  \\__/         "+ ANSI_RESET + "|");
        System.out.println("|" + ANSI_GREEN +"| $$  | $$  \\  $$$/  | $$_____/| $$               "+ ANSI_RESET + "|");
        System.out.println("|" + ANSI_GREEN +"|  $$$$$$/   \\  $/   |  $$$$$$$| $$               "+ ANSI_RESET + "|");
        System.out.println("|" + ANSI_GREEN +" \\______/     \\_/     \\_______/|__/               "+ ANSI_RESET + "|");
        System.out.println(" ------------------------------------------------- ");




    }
    static void mainMenu() {
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +" ______________________________________________________________ "+ ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +"|                             ____                              |"+ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +"|                            / . .\\                             |"+ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +"|                            \\  ---<                            |"+ ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +"|                             \\  /             d8b              |"+ ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +"|                   __________/ /              ?88              |"+ ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +"|     ,--./,-.   -=:___________/               88b              |"+ ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +"|    / #      \\   .d888b,  88bd88b  d888b8b    888  d88' d8888b |"+ ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +"|   |          |  ?8b,     88P' ?8bd8P' ?88    888bd8P' d8b_,dP |"+ ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +"|    \\        /     `?8b  d88   88P88b  ,88b  d88888b   88b     |"+ ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +"|     `._,._,'   `?888P' d88'   88b`?88P'`88bd88' `?88b,`?888P' |"+ ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +"|                                                               |"+ ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +"| Controls: wasd.     Quit: m.    Press enter to start the game.|"+ ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK +" _______________________________________________________________" + ANSI_RESET);


    }
}