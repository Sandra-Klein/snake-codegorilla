package snake;

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