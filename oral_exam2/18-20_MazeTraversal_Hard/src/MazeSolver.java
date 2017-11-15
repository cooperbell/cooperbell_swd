public class MazeSolver {

    private final char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    public void mazeTraversal(int row, int col) {
        Location location = new Location(row, col);

        if (maze[location.goUp()][col] == '.') {  // go up
            maze[location.goUp()][col] = 'x'; // x marks where I go
            printMaze();
            mazeTraversal(location.goUp(), col);
        }

        if (maze[location.goDown()][col] == '.'){ // go down
            maze[location.goDown()][col] = 'x'; // x marks where I go
            printMaze();
            mazeTraversal(location.goDown(), col);
        }

        if (maze[row][location.goForward()] == '.') { // go forward
            maze[row][location.goForward()] = 'x'; // x marks where I go
            printMaze();
            mazeTraversal(row, location.goForward());
        }

        if (maze[row][location.goBack()] == '.'){ // go back, but this might be the recursive backtracking stuff
            maze[row][location.goBack()] = '0'; // x marks where I go
            printMaze();
            mazeTraversal(row, location.goBack());
        }
    }

    public void printMaze(){
        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze[i].length; j++) {
                System.out.print(maze[i][j]);
                if(j == 11){
                    System.out.println("");
                }
            }
        }
    }
}
