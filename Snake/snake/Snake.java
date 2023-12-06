package snake;
class Snake {
    Snake(int value) {
        coordinateArray = new Coordinate[value];
        numberOfElements = value;
    }

    Coordinate[] coordinateArray;
    int numberOfElements;

    void addCoordinateAtTheBack(Coordinate coordinate) {
        coordinateArray[numberOfElements] = coordinate;
        numberOfElements++;
    }

    void moveSnake(Coordinate coordinate) {
        for (int i = numberOfElements; i >= 1; i--) {
            coordinateArray[i] = coordinateArray[i - 1];
        }
        coordinateArray[0] = coordinate;
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