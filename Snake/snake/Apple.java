package snake;

import java.util.Random;

public class Apple {

    private Random random;
    public int[] getCoordinateX() {
        return coordinateX;
    }
    public void setCoordinateX(int[] coordinateX) {
        this.coordinateX = coordinateX;
    }
    public int[] getCoordinateY() {
        return coordinateY;
    }
    public void setCoordinateY(int[] coordinateY) {
        this.coordinateY = coordinateY;
    }

    private int[] coordinateX, coordinateY;
    private int appleX, appleY;
    private void placeApple() {
        appleX = random.nextInt();
        appleY = random.nextInt();
    }

    while (Game[appleX][appleY] != EMPTY_CELL) {
        appleX = random.nextInt(BOARD_SIZE);
        appleY = random.nextInt(BOARD_SIZE);
    }

}
