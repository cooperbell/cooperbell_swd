/**
 * class MazeSolver
 */
public class MazeSolver {

    /**
     * the 2D array maze
     */
    private final char[][] maze;

    /**
     * the starting point row index
     */
    private int entranceRowIndex;

    /**
     * the starting point column index
     */
    private int entranceColIndex;

    /**
     * Constrcutor for MazeSolver class
     *
     * @param maze             maze array
     * @param entranceRowIndex starting row index
     * @param entranceColIndex starting col index
     */
    public MazeSolver(char[][] maze, int entranceRowIndex, int entranceColIndex) {
        this.maze = maze;
        this.entranceRowIndex = entranceRowIndex;
        this.entranceColIndex = entranceColIndex;
    }

    /**
     * Looks to see if there's a dot around it's current position. If there is, recurse into that position and repeat
     * until either a "dead end" or the exit is found. If a dead end is found, back track until the algorithm can find
     * another route to pursue.
     *
     * @param row current row index
     * @param col current column index
     */
    public void mazeTraversal(int row, int col) {
        maze[row][col] = 'x';
        if (!ifExitFound(row, col)) {
            if (maze[row - 1][col] == '.') {  // look up
                maze[row - 1][col] = 'x';
                System.out.println("");
                printMaze();
                mazeTraversal(row - 1, col);
            } else if (maze[row][col + 1] == '.') { // look right
                maze[row][col + 1] = 'x';
                System.out.println("");
                printMaze();
                mazeTraversal(row, col + 1);
            } else if (maze[row + 1][col] == '.') { // look down
                maze[row + 1][col] = 'x';
                System.out.println("");
                printMaze();
                mazeTraversal(row + 1, col);
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

    /**
     * @param row
     * @param col
     * @return
     */
    private boolean ifExitFound(int row, int col) {
        return ((row != entranceRowIndex) && (col != entranceColIndex)) && ((col == 0 || col == 11) || (row == 0 || row == 11));
    }

    /**
     * Prints the 2D array
     */
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
