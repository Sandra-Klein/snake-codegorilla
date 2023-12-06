package snake;

import java.util.Random;

public class Apple {

    private static final char APPLE = 'A';
    private Random random;

    public int[] getCoordinateX() {
        return coordinateX;
    }
    public int[] getCoordinateY() {
        return coordinateY;
    }
    private int[] coordinateX, coordinateY;
    private int appleX, appleY;

    private void placeApple() {
        appleX = random.nextInt();
        appleY = random.nextInt();
    }

    void placeApple(Game game) {
        while (true) {
            int randAppleX = random.nextInt(game.gridArray[0].length);
            int randAppleY = random.nextInt(game.gridArray.length);
            if (game.gridArray[randAppleY][randAppleX] == ' ') {
                game.gridArray[randAppleY][randAppleX] = '*';
                return;
            }
        }
    }
}
