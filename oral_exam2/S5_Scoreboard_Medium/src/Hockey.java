import java.util.HashMap;
import java.util.Map;

/**
 * Class Hockey inherits from class Game
 */
public class Hockey extends Game {

    /**
     * Constructor calls the super's constructor
     *
     * @param team1 First team object
     * @param team2 Second team object
     */
    public Hockey(Team team1, Team team2) {
        super(team1, team2);
    }

    /**
     * Hash map for storing scoring types and its corresponding points
     */
    private static final Map<String, Integer> scoreTypes;

    static {
        scoreTypes = new HashMap<>();
        scoreTypes.put("goal", 1);

    }

    @Override
    public void addScore(String scoreType, Team team) {
        if (scoreTypes.containsKey(scoreType)) {
            team.addScore(scoreTypes.get(scoreType));
        } else {
            System.out.printf("Score type does not exist");
        }
    }

    @Override
    public String getNameOfPeriod() {
        return "Period";
    }

    @Override
    public int getMaxPeriods() {
        return 3;
    }

    @Override
    public int getLengthOfPeriod() {
        return 20;
    }
}
