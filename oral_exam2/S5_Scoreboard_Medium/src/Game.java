/**
 * Abstract class Game from which all other game type classes inherit from
 */
public abstract class Game {

    /**
     * Team 1 object
     */
    private Team team1;

    /**
     * Team 2 object
     */
    private Team team2;

    /**
     * period keeps track of current period
     */
    private int period = 1;

    /**
     * Constructor for Game initializes the teams
     *
     * @param team1 Team object for team 1
     * @param team2 Team object for team 2
     */
    Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    /**
     * Setter for team 1
     * @param team1 Team object for team 1
     */
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    /**
     * Setter for team 2
     * @param team2 Team object for team 2
     */
    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    /**
     * Getter for team 1
     * @return Team object for team 1
     */
    public Team getTeam1() {
        return team1;
    }

    /**
     * Getter for team 2
     * @return Team object for team 2
     */
    public Team getTeam2() {
        return team2;
    }

    /**
     * Returns whether the game is over
     * @return boolean for whether the game is over
     */
    public boolean isGameOver() {
        return getCurrentPeriod() > getMaxPeriods();
    }

    /**
     *  ends current period by incrementing the period variable
     */
    public void endCurrentPeriod() {
        period++;
    }

    /**
     * Getter for the period variable
     * @return period variable
     */
    public int getCurrentPeriod() {
        return period;
    }

    /**
     * Getter for the winning team
     * @return Team object of the team with the higher score
     */
    public Team getWinningTeam() {
        if (team1.getScore() > team2.getScore()) return team1;
        return team2;
    }

    /**
     * Adds points to specified team
     * @param scoreType type of score for the current game i.e. touchdown, field goal
     * @param team Team object
     */
    public abstract void addScore(String scoreType, Team team);

    /**
     * Getter for current game's name of period
     * @return String for the name of period
     */
    public abstract String getNameOfPeriod();

    /**
     * Getter for the max number of periods for current game
     * @return integer representing max number of periods
     */
    public abstract int getMaxPeriods();

    /**
     * Getter for length of period
     * @return integer representing the length of current game's period
     */
    public abstract int getLengthOfPeriod();


}
