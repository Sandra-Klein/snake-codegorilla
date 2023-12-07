package snake;

import java.util.Random;

class AppleGenerator {
    private static final Random random = new Random();
    static Coordinate generateAppleCoordinates(TileEnum[][] gridArray) {
        while (true) {
            int randAppleX = random.nextInt(gridArray[0].length);
            int randAppleY = random.nextInt(gridArray.length);
            if (gridArray[randAppleY][randAppleX] == TileEnum.EMPTY) {
                return new Coordinate(randAppleX, randAppleY);
            }
        }
    }
}
