public abstract class Game {

    private Team team1;

    private Team team2;

    private boolean gameOver = false;

    private boolean startGame = false;

    private Team winningTeam;

    private int period = 1;


    //private

    Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void startGame() {
        startGame = true;
    }

    public abstract boolean isGameOver();

    public void endCurrentPeriod(){
       period++;
       if(isGameOver()){
           gameOver = true;
           startGame = false;
       }
    }

    public int getCurrentPeriod(){
        return period;
    }

    public abstract void addScore(String scoreType, Team team);

    public abstract String getNameofPeriod();

    public abstract int getMaxPeriods();

}
