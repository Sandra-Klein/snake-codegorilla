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
        Snake snakeGame = new Snake(new Coordinate(9, 9));
        Render display = new Render();
        System.out.println(display.buildDisplayString(snakeGame));
        input.startGame();
        try {
            while (input.gameStarted) {
                GameAction action = input.getUserInput();
                snakeGame.setCurrentDir(input.lastDirection);
                if (action == GameAction.GAME_QUIT) {
                    input.gameStarted = false;
                }
                Render.clear();
                snakeGame.move();
                snakeGame.updateGrid();
                System.out.println(display.buildDisplayString(snakeGame));
            }
        } catch (Exception e) {
            System.out.println("Game over");
        }
    }
}