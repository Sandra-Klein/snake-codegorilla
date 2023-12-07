package snake;

abstract class Game {
    private static TileEnum[][] gridArray;
    static TileEnum[][] getOriginalGrid() {
        Game.gridArray = new TileEnum[20][20];
        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray.length; j++) {
                Game.gridArray[i][j] = TileEnum.EMPTY;
            }
        }
        return Game.gridArray;
    }
}
enum TileEnum {
    SNAKE('@'), EMPTY(' '), APPLE('*');
    private final char c;
    TileEnum(char c) {
        this.c = c;
    }
    public char getValue() {
        return this.c;
    }
}