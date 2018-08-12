import tennis.Plays;
import tennis.Score;

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


    public String computeScore(List<Boolean> plays) {
        return compteScoreRecursive(plays, new Score(LOVE, LOVE));
    }


    public String compteScoreRecursive(List<Boolean> plays, Score score) {
        if (plays.size() == 0) {
            return score.toString();
        }
        //joueur 1 a gagné
        if (plays.get(0)) {
            if (score.getScorePlayer1().equalsIgnoreCase(FOURTY)) {
                if (score.getScorePlayer2().equalsIgnoreCase(FOURTY)) {
                    score.setScorePlayer1(ADVANTAGE_IN);
                } else {
                    //win !
                }
            } else {
                score.setScorePlayer1(MARKS.get(MARKS.indexOf(score.getScorePlayer1()) + 1));

            }
        } else {
            if (score.getScorePlayer2().equalsIgnoreCase(FOURTY)) {
                if (score.getScorePlayer1().equalsIgnoreCase(FOURTY)) {
                    score.setScorePlayer2(ADVANTAGE_OUT);
                }
            } else {
                score.setScorePlayer2(MARKS.get(MARKS.indexOf(score.getScorePlayer2()) + 1));

            }
        }
        plays.remove(0);
        return compteScoreRecursive(plays, score);
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
