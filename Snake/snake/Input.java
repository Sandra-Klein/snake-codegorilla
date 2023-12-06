package snake;

import java.io.BufferedInputStream;
import java.io.IOException;

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
    public Input() {
        this.gameStarted = false;
        this.lastDirection = null;
    }
    public void startGame() {
        if (!gameStarted) {
            gameStarted = true;
        }
    }

    GameAction getUserInput() throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(System.in);
        if (!gameStarted) {
            char startInput = (char) inputStream.read();
            if (startInput == 'n') {
                startGame();
                return GameAction.GAME_START;
            } else {
                return getUserInput();
            }
        } else {
            char userInput = (char) inputStream.read();
            switch (userInput) {
                case 'w':
                    if (lastDirection == Directions.DOWN) {
                        return getUserInput();
                    }
                    lastDirection = Directions.UP;
                    return GameAction.MOVE_UP;

                case 's':
                    if (lastDirection == Directions.UP) {
                        return getUserInput();
                    }
                    lastDirection = Directions.DOWN;
                    return GameAction.MOVE_DOWN;

                case 'a':
                    if (lastDirection == Directions.RIGHT) {
                        return getUserInput();
                    }
                    lastDirection = Directions.LEFT;
                    return GameAction.MOVE_LEFT;

                case 'd':
                    if (lastDirection == Directions.LEFT) {
                        return getUserInput();
                    }
                    lastDirection = Directions.RIGHT;
                    return GameAction.MOVE_RIGHT;

                case 'm':
                    return GameAction.GAME_QUIT;

                default:
                    return getUserInput();
            }
        }
    }
}