import java.util.HashMap;
import java.util.Map;

/**
 * Created by coopbell on 11/14/17.
 */
public class Hockey extends Game {

    /**
     *
     * @param team1
     * @param team2
     */
    public Hockey(Team team1, Team team2) {
        super(team1, team2);
    }

    /**
     *
     */
    private static final Map<String, Integer> scoreTypes;

    static {
        scoreTypes = new HashMap<>();
        scoreTypes.put("goal", 1);

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
        return "Period";
    }

    /**
     *
     * @return
     */
    @Override
    public int getMaxPeriods() {
        return 3;
    }

    /**
     *
     * @return
     */
    @Override
    public int getLengthOfPeriod() {
        return 20;
    }
}
