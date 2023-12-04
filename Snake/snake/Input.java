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
    QUIT
}

public class Input {
    private Scanner scanner;
    public Input() {
        this.scanner = new Scanner(System.in);
    }
    public GameAction getUserInput() {
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
                return GameAction.QUIT;
            default:
                System.out.println("Invalid input.");
                return getUserInput();
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
                case QUIT:
                    System.out.println("Closing game.");
                    gameRunning = false;
                    break;
            }
        }

        gameInput.closeScanner();
    }
}
