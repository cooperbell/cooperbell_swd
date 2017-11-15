public class Location {

    private int row;

    private int col;

    public Location(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int goUp(){
        return row--;
    }

    public int goDown(){
        return row++;
    }

    public int goForward(){
        return col++;
    }

    public int goBack(){
        return col--;
    }
}
