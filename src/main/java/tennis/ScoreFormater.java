package tennis;

import java.util.List;

public class ScoreFormater {


    public static final String SPACE = " ";
    public static final String COLON = ":";
    public static final String TILT = "|";

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
                    .append("A");
            return resultat.toString();
        }
        if (score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase("advantage in")) {
            resultat.append(score.getGamesInCurrentSetPlayer1()).append("|").append(score.getGamesInCurrentSetPlayer2()).append(" ").append(score.getScoreInTheCurrentGamePlayer1());
            return resultat.toString();
        } else if (score.getScoreInTheCurrentGamePlayer2().equalsIgnoreCase("advantage out")) {
            resultat.append(score.getGamesInCurrentSetPlayer1()).append("|").append(score.getGamesInCurrentSetPlayer2()).append(" ").append(score.getScoreInTheCurrentGamePlayer2());
            return resultat.toString();
        }
        if (score.getFinishedSets().stream().filter(x -> x.getGameInSetPlayer2() - x.getGamePlayer1() >= 1 && x.getGameInSetPlayer2() >= 6).count() == 3) {
            return resultat.append("player 2 won").toString();
        } else if (score.getFinishedSets().stream().filter(x -> x.getGamePlayer1() - x.getGameInSetPlayer2() >= 1 && x.getGamePlayer1() >= 6).count() == 3) {
            return resultat.append("player 1 won").toString();
        }
        return resultat.append(score.getGamesInCurrentSetPlayer1())
                .append(TILT)
                .append(score.getGamesInCurrentSetPlayer2())
                .append(SPACE)
                .append(score.getScoreInTheCurrentGamePlayer1())
                .append(COLON)
                .append(score.getScoreInTheCurrentGamePlayer2())
                .toString();
    }

    public void addPreviousSetsResults(StringBuilder resultat, List<FinishedSet> finishedSets) {
        for (FinishedSet finishedSet : finishedSets) {
            resultat.append(finishedSet.getGamePlayer1() + "|" + finishedSet.getGameInSetPlayer2() + " ");
        }
    }
}