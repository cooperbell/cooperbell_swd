public class Team {

    private String teamName;

    private int points = 0;

    public Team(String teamName){
        this.teamName = teamName;
    }

    public void addScore(int score){
        points += score;
    }

    public int getScore(){
        return points;
    }

    public String getTeamName() {
        return teamName;
    }
}
