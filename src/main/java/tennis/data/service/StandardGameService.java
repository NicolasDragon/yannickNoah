package tennis.data.service;

import tennis.Score;

import java.util.Arrays;
import java.util.List;

/**
 * ici on a la logique du calcul du score dans un jeu
 */
public class StandardGameService extends GameService {
    public static final String LOVE = "love";
    public static final String FOURTY = "40";
    public static final String ADVANTAGE_IN = "advantage in";
    public static final String ADVANTAGE_OUT = "advantage out";
    private static final String FIFTEEN = "15";
    private static final String THIRTY = "30";
    private static final List<String> MARKS = Arrays.asList(LOVE, FIFTEEN, THIRTY, FOURTY);

    void computeScoreInNormalGameWhenPlayer1WonTheGame(Score score) {
        // cas advantage
        if (score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(ADVANTAGE_IN)) {
            changerScoreWhenPlayer1WonTheGame(score);
            //cas gain de l'avantage
        } else if (score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(FOURTY)) {
            if (score.getScoreInTheCurrentGamePlayer2().equalsIgnoreCase(FOURTY)) {
                score.setScoreInTheCurrentGamePlayer1(ADVANTAGE_IN);
            } else {
                changerScoreWhenPlayer1WonTheGame(score);
            }
        } else {
            //default case where we take the next index
            String scoreInTheCurrentGamePlayer1 = getNewScoreAfterPlayWon(score.getScoreInTheCurrentGamePlayer1());
            score.setScoreInTheCurrentGamePlayer1(scoreInTheCurrentGamePlayer1);

        }
    }

    void computeScoreInNormalGameWhenPlayer2WonTheGame(Score score) {
        if (score.getScoreInTheCurrentGamePlayer2().equalsIgnoreCase(ADVANTAGE_OUT)) {
            changeScoreWhenPlayer2WonTheGame(score, score.getCurrentSet());
            //cas du 40A
        } else if (score.getScoreInTheCurrentGamePlayer2().equalsIgnoreCase(FOURTY)) {
            if (score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(FOURTY)) {
                score.setScoreInTheCurrentGamePlayer2(ADVANTAGE_OUT);
            } else {
            changeScoreWhenPlayer2WonTheGame(score, score.getCurrentSet());
            }
        } else {
            String scoreInTheCurrentGamePlayer2 = getNewScoreAfterPlayWon(score.getScoreInTheCurrentGamePlayer2());
            score.setScoreInTheCurrentGamePlayer2(scoreInTheCurrentGamePlayer2);

        }
    }

    public String getNewScoreAfterPlayWon(String scoreInTheCurrentGamePlayer2) {
        int indexOfCurrentPlayerScore = MARKS.indexOf(scoreInTheCurrentGamePlayer2);
        int indexOfNextScore = indexOfCurrentPlayerScore + 1;
        return MARKS.get(indexOfNextScore);
    }
}