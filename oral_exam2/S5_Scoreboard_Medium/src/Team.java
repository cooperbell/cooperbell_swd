/**
 * Class for the teams
 */
public class Team {

    /**
     * String of the team's name
     */
    private String teamName;

    /**
     * team's current points
     */
    private int points = 0;

    /**
     * Constructor initializes teamName variable
     * @param teamName String of team;s name
     */
    public Team(String teamName){
        this.teamName = teamName;
    }

    /**
     * adds points to total score
     * @param score points to add
     */
    public void addScore(int score){
        points += score;
    }

    /**
     * Getter for current score
     * @return points variable
     */
    public int getScore(){
        return points;
    }

    /**
     * Getter for team name
     * @return teamName variable
     */
    public String getTeamName() {
        return teamName;
    }
}
