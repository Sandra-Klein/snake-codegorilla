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
    private final Scanner scanner;
    boolean gameStarted;
    Directions lastDirection;
    public Input() {
        this.scanner = new Scanner(System.in);
        this.gameStarted = false;
        this.lastDirection = null;
    }
    public void startGame() {
        if (!gameStarted) {
            gameStarted = true;
        }
    }

    GameAction getUserInput() {
        if (!gameStarted) {
            String startInput = scanner.nextLine().toUpperCase();

            if (startInput.equals("START")) {
                startGame();
                return GameAction.GAME_START;
            } else {
                return getUserInput();
            }
        } else {
            System.out.println("Enter your move (W, S, A, D, QUIT): ");
            String userInput = scanner.nextLine().toUpperCase();

            switch (userInput) {
                case "W":
                    if (lastDirection == Directions.DOWN) {
                        return getUserInput();
                    }
                    lastDirection = Directions.UP;
                    return GameAction.MOVE_UP;

                case "S":
                    if (lastDirection == Directions.UP) {
                        return getUserInput();
                    }
                    lastDirection = Directions.DOWN;
                    return GameAction.MOVE_DOWN;

                case "A":
                    if (lastDirection == Directions.RIGHT) {
                        return getUserInput();
                    }
                    lastDirection = Directions.LEFT;
                    return GameAction.MOVE_LEFT;

                case "D":
                    if (lastDirection == Directions.LEFT) {
                        return getUserInput();
                    }
                    lastDirection = Directions.RIGHT;
                    return GameAction.MOVE_RIGHT;

                case "QUIT":
                    return GameAction.GAME_QUIT;

                default:
                    return getUserInput();
            }
        }
    }
    public void closeScanner() {
        scanner.close();
    }
}