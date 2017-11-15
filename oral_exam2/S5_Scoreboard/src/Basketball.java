import java.util.HashMap;
import java.util.Map;

public class Basketball extends Game{

    public Basketball(Team team1, Team team2) {
        super(team1, team2);
    }

    private static final Map<String, Integer> scoreTypes;

    static { //TODO: probably better to do enumerated types
        scoreTypes = new HashMap<>();
        scoreTypes.put("Three Pointer", 3);
        scoreTypes.put("Two Pointer", 2);
        scoreTypes.put("Free Throw", 1);
    }

    @Override
    public boolean isGameOver() {
        return getCurrentPeriod() > getMaxPeriods();
    }

    @Override
    public void addScore(String scoreType, Team team) {
        team.addScore(scoreTypes.get(scoreType));
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
