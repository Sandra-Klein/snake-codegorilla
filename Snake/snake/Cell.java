package snake;

public class Cell {
    char[][] gridArray;

    Cell() {
        this.gridArray = new char[20][20];
        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray.length; j++) {
                this.gridArray[i][j] = '.';
            }
        }
    }

    public String toString() {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < this.gridArray.length; i++) {
            for (int j = 0; j < this.gridArray.length; j++) {
                message.append(this.gridArray[i][j]);
            }
            message.append("\n");
        }
        return message.toString();
    }
}






