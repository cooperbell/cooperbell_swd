import java.util.HashMap;
import java.util.Map;

/**
 * Class for a basketball game. Inherits from class Game
 */
public class Basketball extends Game {

    /**
     * Constructor calls the super's constructor
     *
     * @param team1 First team object
     * @param team2 Second team object
     */
    public Basketball(Team team1, Team team2) {
        super(team1, team2);
    }

    /**
     * Hash map for storing scoring types and its corresponding points
     */
    private static final Map<String, Integer> scoreTypes;

    static {
        scoreTypes = new HashMap<>();
        scoreTypes.put("Three Pointer", 3);
        scoreTypes.put("Two Pointer", 2);
        scoreTypes.put("Free Throw", 1);
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
        return "quarter";
    }

    @Override
    public int getMaxPeriods() {
        return 4;
    }

    @Override
    public int getLengthOfPeriod() {
        return 12;
    }
}
