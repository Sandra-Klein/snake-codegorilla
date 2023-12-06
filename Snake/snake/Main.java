package snake;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Controls: wasd\nQuit: m");
        Input input = new Input();
        Snake snake = new Snake(1);
        snake.pointSnake(new Coordinate(9,9));
        Game game = new Game();
        Render display = new Render();
        input.startGame();
        while(input.gameStarted) {
            GameAction action = input.getUserInput();
            if (action == GameAction.GAME_QUIT) {
                input.gameStarted = false;
            }
            Render.clear();
            snake.snakeArray[0].update(input.lastDirection);
            snake.placeSnake(game);
            if (game.coordinatesOutOfBounds(snake.snakeArray[0].x, snake.snakeArray[0].y)) {
                System.out.println("GAME OVER!");
                input.gameStarted = false;
            } else {
                String displayMessage = display.buildDisplayString(game);
                System.out.println(displayMessage);
            }
            Thread.sleep(350, 0);
        }
    }
}