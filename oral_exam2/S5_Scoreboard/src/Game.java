public abstract class Game {

    /**
     *
     */
    private Team team1;

    /**
     *
     */
    private Team team2;

    /**
     *
     */
    private int period = 1;

    /**
     * @param team1
     * @param team2
     */
    Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    /**
     * @param team1
     */
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    /**
     * @param team2
     */
    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    /**
     * @return
     */
    public Team getTeam1() {
        return team1;
    }

    /**
     * @return
     */
    public Team getTeam2() {
        return team2;
    }

    /**
     * @return
     */
    public boolean isGameOver() {
        return getCurrentPeriod() > getMaxPeriods();
    }

    /**
     *
     */
    public void endCurrentPeriod() {
        period++;
    }

    /**
     * @return
     */
    public int getCurrentPeriod() {
        return period;
    }

    public Team getWinningTeam() {
        if (team1.getScore() > team2.getScore()) return team1;
        return team2;
    }

    public abstract void addScore(String scoreType, Team team);

    public abstract String getNameOfPeriod();

    public abstract int getMaxPeriods();

    public abstract int getLengthOfPeriod();


}
