import java.util.HashMap;
import java.util.Map;

public class Football extends Game {

    public Football(Team team1, Team team2) {
        super(team1, team2);
    }

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
        team.addScore(scoreTypes.get(scoreType));
    }

    @Override
    public String getNameofPeriod() {
        return "quarter";
    }

    @Override
    public boolean isGameOver() {
        return getCurrentPeriod() > getMaxPeriods();
    }

    @Override
    public int getMaxPeriods(){
        return 4;
    }

}
