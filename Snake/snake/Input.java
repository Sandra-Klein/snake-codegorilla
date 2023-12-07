package snake;

import java.io.BufferedInputStream;
import java.io.IOException;

import static java.lang.Thread.sleep;

enum GameAction {
    MOVE_UP,
    MOVE_DOWN,
    MOVE_LEFT,
    MOVE_RIGHT,
    GAME_START,
    GAME_QUIT
}

public class Input {
    boolean gameStarted;
    Directions lastDirection;
    GameAction currentInput;
    public Input() {
        this.gameStarted = false;
        this.lastDirection = Directions.RIGHT;
    }
    public void startGame() {
        if (!gameStarted) {
            gameStarted = true;
        }
    }
    public void getUserInput() throws InterruptedException {
        this.currentInput = matchLastDirection(this.lastDirection);
        Runnable t = () -> {
            BufferedInputStream inputStream = new BufferedInputStream(System.in);
            if (!gameStarted) {
                char startInput;
                try {
                    startInput = (char) inputStream.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (startInput == 'n') {
                    startGame();
                    this.currentInput = GameAction.GAME_START;
                }
            } else {
                char userInput;
                try {
                    userInput = (char) inputStream.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                switch (userInput) {
                    case 'w':
                        if (lastDirection == Directions.DOWN) {
                            this.currentInput = GameAction.MOVE_DOWN;
                            break;
                        }
                        lastDirection = Directions.UP;
                        this.currentInput = GameAction.MOVE_UP;
                        break;
                    case 's':
                        if (lastDirection == Directions.UP) {
                            this.currentInput = GameAction.MOVE_UP;
                            break;
                        }
                        lastDirection = Directions.DOWN;
                        this.currentInput = GameAction.MOVE_DOWN;
                        break;
                    case 'a':
                        if (lastDirection == Directions.RIGHT) {
                            this.currentInput = GameAction.MOVE_RIGHT;
                            break;
                        }
                        lastDirection = Directions.LEFT;
                        this.currentInput = GameAction.MOVE_LEFT;
                        break;
                    case 'd':
                        if (lastDirection == Directions.LEFT) {
                            this.currentInput = GameAction.MOVE_LEFT;
                            break;
                        }
                        lastDirection = Directions.RIGHT;
                        this.currentInput = GameAction.MOVE_RIGHT;
                        this.currentInput = matchLastDirection(this.lastDirection);
                        break;
                    case 'm':
                        this.currentInput = GameAction.GAME_QUIT;
                        break;
                    default:
                }
            }
        };
        Thread inputThread = new Thread(t);
        inputThread.start();
        sleep(350);
    }
    private GameAction matchLastDirection(Directions lastDir) {
        return switch (lastDir) {
            case UP -> GameAction.MOVE_UP;
            case DOWN -> GameAction.MOVE_DOWN;
            case LEFT -> GameAction.MOVE_LEFT;
            case RIGHT -> GameAction.MOVE_RIGHT;
        };
    }
}