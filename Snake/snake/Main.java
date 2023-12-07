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
        Snake snakeGame = new Snake(new Coordinate(3,5));
        // snake.pointSnake(new Coordinate(9,9));
        // Game game = new Game();
        Render display = new Render();
        AppleGenerator.generateApple(snakeGame.gridArray);
        String displayMessage = display.buildDisplayString(snakeGame);
        System.out.println(displayMessage);
        /*
        Tijdens het maken van alle objecten voor het spel zou ook het eerste appeltje al geplaatst kunnen worden.
         */
        input.startGame();
    }
}
//         while(input.gameStarted) {
//             GameAction action = input.getUserInput();
//             if (action == GameAction.GAME_QUIT) {
//                 input.gameStarted = false;
//             }
//             Render.clear();
//             game.resetData();
//             snake.updateDirection(input.lastDirection);
//             snake.placeSnake(game);
//             Coordinate appleTestCoordinate = new Coordinate(10, 9);
//             System.out.println(appleTestCoordinate.x + " " + appleTestCoordinate.y);
//             System.out.println(snake.coordinateArray.length);
//             if (snake.coordinateArray[0].x == appleTestCoordinate.x && snake.coordinateArray[0].y == appleTestCoordinate.y) {
//                 /*
//                 Als het nieuwste snakeveld gelijk is aan coordinaten van appel, dan groeit de snake.
//                 Hier zou ook een update kunnen plaatsvinden om de oude appel te verwijderen en een nieuwe te plaatsen.
//                  */
//                 System.out.println("Eating apple!");
//                 snake.eatApple(appleTestCoordinate);
//                 System.out.println(snake.coordinateArray.length);
//             }
//             if (game.coordinatesOutOfBounds(snake.coordinateArray[0].x, snake.coordinateArray[0].y)) {
//                 System.out.println("GAME OVER!");
//                 input.gameStarted = false;
//             } else {
//                 String displayMessage = display.buildDisplayString(game);
//                 System.out.println(displayMessage);
//             }
//             for (int i = 0; i < snake.coordinateArray.length; i++) {
//                 System.out.println(i + " x: " + snake.coordinateArray[i].x + " y: " + snake.coordinateArray[i].y);
//             }
//             Thread.sleep(350, 0);
//         }
//     }
// }