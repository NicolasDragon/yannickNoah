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
        return compteScoreRecursive(plays, new Score());
    }


    private String compteScoreRecursive(List<Boolean> plays, Score score) {
        if (plays.size() == 0) {
            return score.toString();
        }
        //joueur 1 a gagné
        if (plays.get(0)) {
            computeScoreWhenFirstPlayerWonTheBall(score);
        } else {
            compteScoreWhenSecondPlayerWonTheBall(score);
        }
        plays.remove(0);
        return compteScoreRecursive(plays, score);
    }

    private void compteScoreWhenSecondPlayerWonTheBall(Score score) {
        //cas de l'avantage
        if (score.getScoreInTheCurrentGamePlayer2().equalsIgnoreCase(ADVANTAGE_OUT)) {
            score.player2wonTheGame();
            //cas du 40A
        } else if (score.getScoreInTheCurrentGamePlayer2().equalsIgnoreCase(FOURTY)) {
            if (score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(FOURTY)) {
                score.setScoreInTheCurrentGamePlayer2(ADVANTAGE_OUT);
            } else {
                score.player2wonTheGame();
            }
        } else {
            String scoreInTheCurrentGamePlayer2 = getNewScoreAfterPlayWon(score.getScoreInTheCurrentGamePlayer2());
            score.setScoreInTheCurrentGamePlayer2(scoreInTheCurrentGamePlayer2);

        }
    }

    private String getNewScoreAfterPlayWon(String scoreInTheCurrentGamePlayer2) {
        int indexOfCurrentPlayerScore = MARKS.indexOf(scoreInTheCurrentGamePlayer2);
        int indexOfNextScore = indexOfCurrentPlayerScore + 1;
        return MARKS.get(indexOfNextScore);
    }

    private void computeScoreWhenFirstPlayerWonTheBall(Score score) {
        // il peut gagner le game et le set
        if (score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(ADVANTAGE_IN)) {
            score.player1wonTheGame();
        } else if (score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(FOURTY)) {
            if (score.getScoreInTheCurrentGamePlayer2().equalsIgnoreCase(FOURTY)) {
                score.setScoreInTheCurrentGamePlayer1(ADVANTAGE_IN);
            } else {
                //win of the set !
                score.player1wonTheGame();
            }
        } else {
            String scoreInTheCurrentGamePlayer1 = getNewScoreAfterPlayWon(score.getScoreInTheCurrentGamePlayer1());
            score.setScoreInTheCurrentGamePlayer1(scoreInTheCurrentGamePlayer1);

        }
    }


}
