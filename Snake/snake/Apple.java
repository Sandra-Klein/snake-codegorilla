package snake;

import java.util.Random;

class AppleGenerator {
    private static final Random random = new Random();
    static void generateApple(TileEnum[][] gridArray) {
        while (true) {
            int randAppleX = random.nextInt(gridArray[0].length);
            int randAppleY = random.nextInt(gridArray.length);
            if (gridArray[randAppleY][randAppleX] == TileEnum.EMPTY) {
                gridArray[randAppleY][randAppleX] = TileEnum.APPLE;
                return;
            }
        }
    }
}
