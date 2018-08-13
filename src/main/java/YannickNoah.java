import tennis.FinishedSet;
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
        if (score.getScoreInTheCurrentGamePlayer2().equalsIgnoreCase(ADVANTAGE_OUT)) {
            score.player2wonTheGame();
        } else if (score.getScoreInTheCurrentGamePlayer2().equalsIgnoreCase(FOURTY)) {
            if (score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(FOURTY)) {
                score.setScoreInTheCurrentGamePlayer2(ADVANTAGE_OUT);
            } else {
                //win of the set !
                if (score.getGamesInCurrentSetPlayer2() == 5 && score.getGamesInCurrentSetPlayer1() < 5) {
                    score.player2wonTheGame();
                    score.getFinishedSets().add(new FinishedSet(score.getGamesInCurrentSetPlayer2(), score.getGamesInCurrentSetPlayer1()));
                    clearGamesInCurrentSet(score);
                } else {
                    //win of the game !
                    score.player2wonTheGame();
                }
            }
        } else {
            int indexOfCurrentPlayerScore = MARKS.indexOf(score.getScoreInTheCurrentGamePlayer2());
            int indexOfNextScore = indexOfCurrentPlayerScore + 1;
            score.setScoreInTheCurrentGamePlayer2(MARKS.get(indexOfNextScore));

        }
    }

    private void computeScoreWhenFirstPlayerWonTheBall(Score score) {
        if (score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(ADVANTAGE_IN)) {
            score.player1wonTheGame();
        } else if (score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(FOURTY)) {
            if (score.getScoreInTheCurrentGamePlayer2().equalsIgnoreCase(FOURTY)) {
                score.setScoreInTheCurrentGamePlayer1(ADVANTAGE_IN);
            } else {
                //win of the set !
                if (score.getGamesInCurrentSetPlayer1() == 5 && score.getGamesInCurrentSetPlayer2() < 5) {
                    score.player1wonTheGame();
                    score.getFinishedSets().add(new FinishedSet(score.getGamesInCurrentSetPlayer2(), score.getGamesInCurrentSetPlayer1()));

                    clearGamesInCurrentSet(score);
                } else {
                    //win of the game !
                    score.player1wonTheGame();
                }
            }
        } else {
            int indexOfCurrentPlayerScore = MARKS.indexOf(score.getScoreInTheCurrentGamePlayer1());
            int indexOfNextScore = indexOfCurrentPlayerScore + 1;
            score.setScoreInTheCurrentGamePlayer1(MARKS.get(indexOfNextScore));

        }
    }

    private void clearGamesInCurrentSet(Score score) {
        score.setGamesInCurrentSetPlayer1(0);
        score.setGamesInCurrentSetPlayer2(0);
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
