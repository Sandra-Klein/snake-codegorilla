package snake;

import java.util.ArrayList;
public class Snake extends Game {
    TileEnum[][] gridArray;
    Directions currentDir;
    Coordinate snakeHead;
    ArrayList<Coordinate> coordinateArray;
    Snake(Coordinate startPos) {
        this.snakeHead = startPos;
        this.coordinateArray = new ArrayList<>();
        this.updateGrid();
    }
    public void setCurrentDir(Directions currentDir) {
        this.currentDir = currentDir;
    }
    public void updateGrid() {
        this.gridArray = super.getOriginalGrid();
        this.placeSnake();
    }
    private void placeSnake() {
        for (Coordinate coordinate : this.coordinateArray) {
            this.gridArray[coordinate.y][coordinate.x] = TileEnum.SNAKE;
        }
        this.gridArray[snakeHead.y][snakeHead.x] = TileEnum.SNAKE;
    }
}

class Coordinate {
    int x, y;
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean collides(Coordinate otherCoordinate) {
        return this.x == otherCoordinate.x && this.y == otherCoordinate.y;
    }
    void update(Directions option) {
        switch (option) {
            case UP:
                this.y--;
                break;
            case DOWN:
                this.y++;
                break;
            case LEFT:
                this.x--;
                break;
            case RIGHT:
                this.x++;
                break;
        }
    }
}

/*
class Snake {
    void eatApple(Coordinate frontCoordinate) {
        numberOfElements++;
        Coordinate[] newSnakeArray = new Coordinate[numberOfElements];
        newSnakeArray[0] = frontCoordinate;
        for (int i = 1; i < numberOfElements; i++) {
            newSnakeArray[i] = this.coordinateArray[i - 1];
        }
        this.coordinateArray = newSnakeArray;
    }
    void updateDirection(Directions direction) {
        for (int i = 1; i < this.coordinateArray.length; i++) {
            this.coordinateArray[i] = this.coordinateArray[i-1];
        }
        this.coordinateArray[0].update(direction);
    }
}
 */