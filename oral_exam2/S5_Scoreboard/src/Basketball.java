import java.util.HashMap;
import java.util.Map;

public class Basketball extends Game{

    public Basketball(Team team1, Team team2) {
        super(team1, team2);
    }

    private static final Map<String, Integer> scoreTypes;

    static {
        scoreTypes = new HashMap<>();
        scoreTypes.put("Three-Pointer", 3);
        scoreTypes.put("Two-Pointer", 2);
        scoreTypes.put("Foul Shot", 1);
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public void addScore(String scoreType, Team team) {

    }

    @Override
    public String getNameOfPeriod() {
        return null;
    }

    @Override
    public int getMaxPeriods() {
        return 0;
    }

    @Override
    public int getLengthOfPeriod() {
        return 0;
    }
}
