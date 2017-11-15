public class MazeTraversalTest {
    public static char[][] maze = new char[12][12];

    static {
        maze[0][0] = '#'; maze[0][1] = '#'; maze[0][2] = '#'; maze[0][3] = '#'; maze[0][4] = '#'; maze[0][5] = '#'; maze[0][6] = '#'; maze[0][7] = '#'; maze[0][8] = '#'; maze[0][9] = '#'; maze[0][10] = '#'; maze[0][11] = '#';
        maze[1][0] = '#'; maze[1][1] = '.'; maze[1][2] = '.'; maze[1][3] = '.'; maze[1][4] = '#'; maze[1][5] = '#'; maze[1][6] = '#';
        maze[2][0] = '.'; maze[2][1] = '.'; maze[2][2] = '#'; maze[2][3] = '.'; maze[2][4] = '#'; maze[2][5] = '#'; maze[2][6] = '#';
        maze[3][0] = '#'; maze[3][1] = '#'; maze[3][2] = '#'; maze[3][3] = '.'; maze[3][4] = '#'; maze[3][5] = '#'; maze[3][6] = '#';
        maze[4][0] = '#'; maze[4][1] = '.'; maze[4][2] = '.'; maze[4][3] = '.'; maze[4][4] = '#'; maze[4][5] = '#'; maze[4][6] = '#';
        maze[5][0] = '#'; maze[5][1] = '#'; maze[5][2] = '#'; maze[5][3] = '#'; maze[5][4] = '#'; maze[5][5] = '#'; maze[5][6] = '#';
        maze[6][0] = '#'; maze[6][1] = '.'; maze[6][2] = '.'; maze[6][3] = '#'; maze[6][4] = '#'; maze[6][5] = '#'; maze[6][6] = '#';
        maze[7][0] = '#'; maze[7][1] = '#'; maze[7][2] = '.'; maze[7][3] = '#'; maze[7][4] = '#'; maze[7][5] = '#'; maze[7][6] = '#';
        maze[8][0] = '#'; maze[8][1] = '.'; maze[8][2] = '.'; maze[8][3] = '.'; maze[8][4] = '#'; maze[8][5] = '#'; maze[8][6] = '#';
        maze[9][0] = '#'; maze[9][1] = '#'; maze[9][2] = '#'; maze[9][3] = '#'; maze[9][4] = '#'; maze[9][5] = '#'; maze[9][6] = '#';
        maze[10][0] = '#'; maze[10][1] = '.'; maze[10][2] = '.'; maze[10][3] = '.'; maze[10][4] = '#'; maze[10][5] = '#'; maze[10][6] = '#';
        maze[11][0] = '#'; maze[11][1] = '#'; maze[11][2] = '#'; maze[11][3] = '#'; maze[11][4] = '#'; maze[11][5] = '#'; maze[11][6] = '#';



    }

    public static void main(String[] args) {
        MazeSolver mazeSolver = new MazeSolver(maze);
        mazeSolver.printMaze();
        mazeSolver.mazeTraversal(0, 3);
    }
}
