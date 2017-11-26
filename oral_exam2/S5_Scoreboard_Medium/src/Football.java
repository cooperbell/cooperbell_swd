import java.util.HashMap;
import java.util.Map;

/**
 * Class Football. Inherits from class Game
 */
public class Football extends Game {

    /**
     * Constructor calls the super's constructor
     *
     * @param team1 First team object
     * @param team2 Second team object
     */
    public Football(Team team1, Team team2) {
        super(team1, team2);
    }

    /**
     * Hash map for storing scoring types and its corresponding points
     */
    private static final Map<String, Integer> scoreTypes;

    static {
        scoreTypes = new HashMap<>();
        scoreTypes.put("touchdown", 7);
        scoreTypes.put("field goal", 3);
        scoreTypes.put("extra point", 1);
        scoreTypes.put("two point conversion", 2);
        scoreTypes.put("safety", 2);
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
        return 15;
    }

}
