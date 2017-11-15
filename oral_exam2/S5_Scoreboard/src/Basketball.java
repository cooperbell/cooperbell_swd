import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Basketball extends Game{

    /**
     *
     * @param team1
     * @param team2
     */
    public Basketball(Team team1, Team team2) {
        super(team1, team2);
    }

    /**
     *
     */
    private static final Map<String, Integer> scoreTypes;

    static { //TODO: probably better to do enumerated types
        scoreTypes = new HashMap<>();
        scoreTypes.put("Three Pointer", 3);
        scoreTypes.put("Two Pointer", 2);
        scoreTypes.put("Free Throw", 1);
    }

    /**
     *
     * @param scoreType
     * @param team
     */
    @Override
    public void addScore(String scoreType, Team team) {
        team.addScore(scoreTypes.get(scoreType));
    }

    /**
     *
     * @return
     */
    @Override
    public String getNameOfPeriod() {
        return "quarter";
    }

    /**
     *
     * @return
     */
    @Override
    public int getMaxPeriods() {
        return 4;
    }

    /**
     *
     * @return
     */
    @Override
    public int getLengthOfPeriod() {
        return 12;
    }
}
