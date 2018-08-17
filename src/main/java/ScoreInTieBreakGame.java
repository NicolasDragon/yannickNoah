import tennis.Score;

public class ScoreInTieBreakGame {

    void computeScoreInTieBreakGameWhenPlayer1WonThePlay(Score score) {
        if (score.getScoreInTheCurrentGamePlayer1().equals(ScoreInNormalGame.LOVE)) {
            score.setScoreInTheCurrentGamePlayer1("1");
        } else {
            if (Integer.valueOf(score.getScoreInTheCurrentGamePlayer1()) >= 6) {
                score.player1wonTheGame();
            } else {
                score.setScoreInTheCurrentGamePlayer1(String.valueOf(Integer.valueOf(score.getScoreInTheCurrentGamePlayer1()) + 1));

            }
        }
    }
}