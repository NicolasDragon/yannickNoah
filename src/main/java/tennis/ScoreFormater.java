package tennis;

import java.util.List;
import java.util.function.Predicate;

public class ScoreFormater {


    public static final String SPACE = " ";
    public static final String COLON = ":";
    public static final String TILT = "|";
    public static final String PLAYER_2_WON = "player 2 won";
    public static final String PLAYER_1_WON = "player 1 won";
    public static final int WON_SET_NUMBER_TO_WIN = 3;
    public static final String A_EQUALITY = "A";

    public String toString(Score score) {
        StringBuilder resultat = new StringBuilder();
        addPreviousSetsResults(resultat, score.getFinishedSets());
        if (!score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(ScoreInNormalGame.LOVE)
                && score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(score.getScoreInTheCurrentGamePlayer2())) {
            resultat.append(score.getGamesInCurrentSetPlayer1())
                    .append(TILT)
                    .append(score.getGamesInCurrentSetPlayer2())
                    .append(SPACE)
                    .append(score.getScoreInTheCurrentGamePlayer1())
                    .append(A_EQUALITY);
        } else if (score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(ScoreInNormalGame.ADVANTAGE_IN)) {
            resultat.append(score.getGamesInCurrentSetPlayer1())
                    .append(TILT)
                    .append(score.getGamesInCurrentSetPlayer2())
                    .append(SPACE)
                    .append(score.getScoreInTheCurrentGamePlayer1());
        } else if (score.getScoreInTheCurrentGamePlayer2().equalsIgnoreCase(ScoreInNormalGame.ADVANTAGE_OUT)) {
            resultat.append(score.getGamesInCurrentSetPlayer1())
                    .append(TILT)
                    .append(score.getGamesInCurrentSetPlayer2())
                    .append(SPACE)
                    .append(score.getScoreInTheCurrentGamePlayer2());
        } else if (hasPlayer2WonTheMatch(score)) {
            resultat.append(PLAYER_2_WON);
        } else if (hasPlayer1WonTheGame(score)) {
            resultat.append(PLAYER_1_WON);
        } else {
            resultat.append(score.getGamesInCurrentSetPlayer1())
                    .append(TILT)
                    .append(score.getGamesInCurrentSetPlayer2())
                    .append(SPACE)
                    .append(score.getScoreInTheCurrentGamePlayer1())
                    .append(COLON)
                    .append(score.getScoreInTheCurrentGamePlayer2());
        }
        return resultat.toString();
    }
//logique métier dans le formatter pas terrible... à voir comment gérer cela
    private boolean hasPlayer1WonTheGame(Score score) {
        return score.getFinishedSets().stream().filter(finishedSetWonByPlayer1()).count() == WON_SET_NUMBER_TO_WIN;
    }

    private boolean hasPlayer2WonTheMatch(Score score) {
        return score.getFinishedSets().stream().filter(finishedSetWonByPlayer2()).count() == WON_SET_NUMBER_TO_WIN;
    }

    private Predicate<Set> finishedSetWonByPlayer1() {
        return x -> x.getGamesInFinishedSetPlayer1() - x.getGameInFinishedSetPlayer2() >= 1
                && x.getGamesInFinishedSetPlayer1() >= 6;
    }

    private Predicate<Set> finishedSetWonByPlayer2() {
        return x -> x.getGameInFinishedSetPlayer2() - x.getGamesInFinishedSetPlayer1() >= 1
                && x.getGameInFinishedSetPlayer2() >= 6;
    }

    public void addPreviousSetsResults(StringBuilder resultat, List<Set> finishedSets) {
        for (Set finishedSet : finishedSets) {
            resultat.append(finishedSet.getGamesInFinishedSetPlayer1() + TILT + finishedSet.getGameInFinishedSetPlayer2() + SPACE);
        }
    }
}