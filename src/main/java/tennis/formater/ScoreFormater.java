package tennis.formater;

import tennis.Score;
import tennis.data.service.StandardGameService;
import tennis.data.service.TennisMatchService;

public class ScoreFormater {


    public static final String SPACE = " ";
    public static final String COLON = ":";
    public static final String TILT = "|";
    public static final String PLAYER_2_WON = "player 2 won";
    public static final String PLAYER_1_WON = "player 1 won";
    public static final String A_EQUALITY = "A";
    private final TennisMatchService tennisMatchService = new TennisMatchService();
    private final ScoreSetPartFormatter scoreSetPartFormatter = new ScoreSetPartFormatter();
    private final ScoreAdvantagePartFormatter scoreAdvantagePartFormatter = new ScoreAdvantagePartFormatter();

    public String toString(Score score) {
        StringBuilder result = new StringBuilder();
        scoreSetPartFormatter.addPreviousSetsResults(result, score.getFinishedSets());
        if (isScoreEqualityDifferentFromLove(score)) {
            constructEqualityScore(score, result);
        } else if (score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(StandardGameService.ADVANTAGE_IN)) {
            scoreAdvantagePartFormatter.constructAdvantage(score, result, score.getScoreInTheCurrentGamePlayer1());
        } else if (score.getScoreInTheCurrentGamePlayer2().equalsIgnoreCase(StandardGameService.ADVANTAGE_OUT)) {
            scoreAdvantagePartFormatter.constructAdvantage(score, result, score.getScoreInTheCurrentGamePlayer2());
        } else if (tennisMatchService.hasPlayer2WonTheMatch(score.getFinishedSets())) {
            result.append(PLAYER_2_WON);
        } else if (tennisMatchService.hasPlayer1WonTheMatch(score.getFinishedSets())) {
            result.append(PLAYER_1_WON);
        } else {
            constructScore(score, result);
        }
        return result.toString();
    }

    private boolean isScoreEqualityDifferentFromLove(Score score) {
        return !score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(StandardGameService.LOVE)
                && score.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(score.getScoreInTheCurrentGamePlayer2());
    }

    private void constructScore(Score score, StringBuilder resultat) {
        resultat.append(score.getGamesInCurrentSetPlayer1())
                .append(TILT)
                .append(score.getGamesInCurrentSetPlayer2())
                .append(SPACE)
                .append(score.getScoreInTheCurrentGamePlayer1())
                .append(COLON)
                .append(score.getScoreInTheCurrentGamePlayer2());
    }


    private void constructEqualityScore(Score score, StringBuilder resultat) {
        resultat.append(score.getGamesInCurrentSetPlayer1())
                .append(TILT)
                .append(score.getGamesInCurrentSetPlayer2())
                .append(SPACE)
                .append(score.getScoreInTheCurrentGamePlayer1())
                .append(A_EQUALITY);
    }


}