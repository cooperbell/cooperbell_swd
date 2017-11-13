public class Game {

    private Team team1;

    private Team team2;

    private boolean gameOver = false;

    private boolean startGame = true;

    private Team winningTeam;

    //private

    public Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void setTeam1(Team team1){
        this.team1 = team1;
    }

    public void setTeam2(Team team2){
        this.team2 = team2;
    }

    public Team getTeam1(){
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void addScore(ScoringMethod score, Team team){ //TODO: do the scoring method

    }

    public ScoringMethod getScoringMethods(int index){

    }
}
