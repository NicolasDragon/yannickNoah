import tennis.Plays;

import java.util.Arrays;
import java.util.List;

public class YannickNoah {


    private static final String SCORE_SEPARATOR = ":";
    private static final String FIFTEEN = "15";
    private static final String LOVE = "love";
    private static final String FOURTY = "40";
    private static final String THIRTY = "30";
    private static final List<String> MARKS = Arrays.asList(LOVE, FIFTEEN, THIRTY, FOURTY);
    private static final String ADVANTAGE_IN = "advantage in";
    private static final String ADVANTAGE_OUT = "advantage out";


    public String computeScore(Plays plays) {
        int firstPlayerScore = (int) plays.getPlays().stream().filter(x -> x).count();
        int secondPlayerScore = plays.getPlays().size() - firstPlayerScore;
        if (isStartOfTheGame(plays.getPlays())) {
            return constructInitScore();
        }
        if (plays.getPlays().size() > 6) {
            int diffScores = firstPlayerScore - secondPlayerScore;
            if ((diffScores == 1)) {
                return ADVANTAGE_IN;
            }
            else if (diffScores == -1) {
                return ADVANTAGE_OUT;
            }
        }

        return constructScoreFormat(MARKS.get(firstPlayerScore), MARKS.get(secondPlayerScore));
    }

    private String constructInitScore() {
        return LOVE + SCORE_SEPARATOR + LOVE;
    }

    private boolean isStartOfTheGame(List<Boolean> plays) {
        return plays.size() == 0;
    }

    private String constructScoreFormat(String firstPlayerScore, String secondPlayerScore) {
        if (firstPlayerScore.equalsIgnoreCase(secondPlayerScore) && !firstPlayerScore.equalsIgnoreCase(LOVE)) {
            return constructSameScoreFormat(firstPlayerScore);
        }
        return firstPlayerScore + SCORE_SEPARATOR + secondPlayerScore;
    }

    private String constructSameScoreFormat(String firstPlayerScore) {
        return firstPlayerScore + "A";
    }
}
