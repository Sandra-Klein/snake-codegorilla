package snake;
class Snake {
    Coordinate[] coordinateArray;
    int numberOfElements;
    public void placeSnake(Game game) {
        for (Coordinate coordinate: coordinateArray) {
            game.gridArray[coordinate.y][coordinate.x] = '@';
        }
    }
    public void pointSnake(Coordinate coordinate) {
        coordinateArray = new Coordinate[]{coordinate};
    }
    Snake(int value) {
        coordinateArray = new Coordinate[value];
        numberOfElements = value;
    }
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
class Coordinate {
    int x, y;
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
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