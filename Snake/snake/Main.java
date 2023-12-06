package snake;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("                             d8b              ");
        System.out.println("                             ?88              ");
        System.out.println("                              88b             ");
        System.out.println(" .d888b,  88bd88b  d888b8b    888  d88' d8888b");
        System.out.println(" ?8b,     88P' ?8bd8P' ?88    888bd8P' d8b_,dP");
        System.out.println("   `?8b  d88   88P88b  ,88b  d88888b   88b    ");
        System.out.println("`?888P' d88'   88b`?88P'`88bd88' `?88b,`?888P'");
        System.out.println("                                              ");
        System.out.println("     Controls: wasd.             Quit: m.     ");
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
            game.resetData();
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