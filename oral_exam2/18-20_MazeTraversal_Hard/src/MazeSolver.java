/**
 *
 */
public class MazeSolver {

    /**
     *
     */
    private final char[][] maze;

    /**
     *
     */
    private int entranceRow;

    /**
     *
     */
    private int entranceCol;

    /**
     * @param maze
     * @param entranceRow
     * @param entranceCol
     */
    public MazeSolver(char[][] maze, int entranceRow, int entranceCol) {
        this.maze = maze;
        this.entranceRow = entranceRow;
        this.entranceCol = entranceCol;
    }

    /**
     * @param row
     * @param col
     */
    public void mazeTraversal(int row, int col) {
        maze[row][col] = 'x';
        if (!ifExitFound(row, col)) {
            if (maze[row - 1][col] == '.') {  // look up
                maze[row - 1][col] = 'x';
                System.out.println("");
                printMaze();
                mazeTraversal(row - 1, col);
            } else if (maze[row + 1][col] == '.') { // look down
                maze[row + 1][col] = 'x';
                System.out.println("");
                printMaze();
                mazeTraversal(row + 1, col);
            } else if (maze[row][col + 1] == '.') { // look right
                maze[row][col + 1] = 'x';
                System.out.println("");
                printMaze();
                mazeTraversal(row, col + 1);
            } else if (maze[row][col - 1] == '.') { // look left
                maze[row][col - 1] = 'x';
                System.out.println("");
                printMaze();
                mazeTraversal(row, col - 1);
            } else { //backtracking recursive part, set the x to a 0, start looking for nearby x's, then look for another dot and recurse
                maze[row][col] = '0';
                if (maze[row - 1][col] == 'x') { //look up
                    mazeTraversal(row - 1, col);
                } else if (maze[row][col + 1] == 'x') { //look right
                    mazeTraversal(row, col + 1);
                } else if (maze[row + 1][col] == 'x') { //look down
                    mazeTraversal(row + 1, col);
                } else if (maze[row][col - 1] == 'x') { //look left
                    mazeTraversal(row, col - 1);
                }
            }
        } else {
            System.out.println("Exit found");
        }
    }

    private boolean ifExitFound(int row, int col) {
        if (((row != entranceRow) && (col != entranceCol)) && ((col == 0 || col == 11) || (row == 0 || row == 11)))
            return true;
        return false;
    }

    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
                System.out.print(" ");
                if (j == 11) {
                    System.out.println("");
                }
            }
        }
    }
}
