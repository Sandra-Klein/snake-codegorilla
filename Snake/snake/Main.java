package snake;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Controls: wasd\nQuit: m");
        Input input = new Input();
        Coordinate snake = new Coordinate(9 , 9);
        Game game = new Game();
        Render display = new Render(game.gridArray[0].length, game.gridArray.length);
        input.startGame();
        while(input.gameStarted) {
            GameAction action = input.getUserInput();
            if (action == GameAction.GAME_QUIT) {
                input.gameStarted = false;
            }
            Render.clear();
            snake.update(input.lastDirection);
            if (game.coordinatesOutOfBounds(snake.x, snake.y)) {
                System.out.println("GAME OVER!");
                input.gameStarted = false;
            } else {
                String displayMessage = display.buildDisplayString(snake.x, snake.y);
                System.out.println(displayMessage);
            }
        }
    }
}