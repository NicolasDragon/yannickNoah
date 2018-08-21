package tennis.formater;

import tennis.Score;

public class ScoreAdvantagePartFormatter {
    public ScoreAdvantagePartFormatter() {
    }

    void constructAdvantage(Score score, StringBuilder resultat, String scoreInTheCurrentGamePlayer1) {
        resultat.append(score.getGamesInCurrentSetPlayer1())
                .append(ScoreFormater.TILT)
                .append(score.getGamesInCurrentSetPlayer2())
                .append(ScoreFormater.SPACE)
                .append(scoreInTheCurrentGamePlayer1);
    }
}