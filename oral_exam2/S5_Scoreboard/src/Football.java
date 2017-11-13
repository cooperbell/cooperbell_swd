public class Football extends Game {

    public Football(Team team1, Team team2) {
        super(team1, team2);
    }

    @Override
    public ScoringMethod getScoringMethods(int index) {
        int [] scoringMethods = new int[5];
        scoringMethods[0] = 7; //touchdown
        scoringMethods[1] = 3; //field goal
        scoringMethods[2] = 1; //extra-point
        scoringMethods[3] = 2; //two point conversion
        scoringMethods[4] = 2; //safety

        return scoringMethods[index];
    }

}
