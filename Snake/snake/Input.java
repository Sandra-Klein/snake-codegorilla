package snake;

import java.util.Scanner;

enum Directions {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

enum GameAction {
    MOVE_UP,
    MOVE_DOWN,
    MOVE_LEFT,
    MOVE_RIGHT,
    GAME_START,
    GAME_QUIT
}

public class Input {
    private Scanner scanner;
    private boolean gameStarted;

    public Input() {
        this.scanner = new Scanner(System.in);
        this.gameStarted = false;
    }
    public void startGame() {
        if (!gameStarted) {
            System.out.println("Game started, have fun!");
            gameStarted = true;
        } else {
            System.out.println("The game has already started.");
        }
    }
    public GameAction getUserInput() {
        if (!gameStarted) {
            System.out.println("Enter START to begin the game: ");
            String startInput = scanner.nextLine().toUpperCase();

            if (startInput.equals("START")) {
                startGame();
                return GameAction.GAME_START;
            } else {
                System.out.println("Invalid input.");
                return getUserInput();
            }
        } else {
            System.out.println("Enter your move (W, S, A, D, QUIT): ");
            String userInput = scanner.nextLine().toUpperCase();

            switch (userInput) {
                case "W":
                    return GameAction.MOVE_UP;
                case "S":
                    return GameAction.MOVE_DOWN;
                case "A":
                    return GameAction.MOVE_LEFT;
                case "D":
                    return GameAction.MOVE_RIGHT;
                case "QUIT":
                    return GameAction.GAME_QUIT;
                default:
                    System.out.println("Invalid input.");
                    return getUserInput();
            }
        }
    }
    public void closeScanner() {
        scanner.close();
    }
    public static void main(String[] args) {
        Input gameInput = new Input();

        boolean gameRunning = true;
        while (gameRunning) {
            GameAction userAction = gameInput.getUserInput();

            switch (userAction) {
                case MOVE_UP:
                    System.out.println("Snake moved UP");
                    break;
                case MOVE_DOWN:
                    System.out.println("Snake moved DOWN");
                    break;
                case MOVE_LEFT:
                    System.out.println("Snake moved LEFT");
                    break;
                case MOVE_RIGHT:
                    System.out.println("Snake moved RIGHT");
                    break;
                case GAME_START:
                    break;
                case GAME_QUIT:
                    System.out.println("Closing game.");
                    gameRunning = false;
                    break;
            }
        }

        gameInput.closeScanner();
    }
}
