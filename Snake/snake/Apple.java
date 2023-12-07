package snake;

import java.util.ArrayList;
import java.util.Random;

class AppleGenerator {
    private static final Random random = new Random();
    static Coordinate generateAppleCoordinates(Coordinate snakeHead, ArrayList<Coordinate> snakeBody, int length) {
        ArrayList<Coordinate> localSnake = new ArrayList<>(snakeBody);
        localSnake.add(snakeHead);
        while (true) {
            Coordinate localCoordinate = new Coordinate(random.nextInt(length), random.nextInt(length));
            if (!localSnake.contains(localCoordinate)) {
                return localCoordinate;
            }
        }
    }
}
