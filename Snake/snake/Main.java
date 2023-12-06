package snake;
public class Main {
    public static void main(String[] args) throws Exception {
        Input input = new Input();
        Coordinate snake = new Coordinate(9 , 9);
        Cell cell = new Cell();
        Render display = new Render(cell.gridArray[0].length, cell.gridArray.length);
        input.startGame();
        while(input.gameStarted) {
            GameAction direction = input.getUserInput();
            Render.clear();
            snake.update(input.lastDirection);
            if (cell.coordinatesOutOfBounds(snake.x, snake.y)) {
                System.out.println("GAME OVER!");
                input.gameStarted = false;
            } else {
                String displayMessage = display.buildDisplayString(snake.x, snake.y);
                System.out.println(displayMessage);
            }
        }
    }
}