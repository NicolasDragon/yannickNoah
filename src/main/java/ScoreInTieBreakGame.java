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

    void computeScoreInTieBreakGameWhenPlayer2WonThePlay(Score score) {
        if (score.getScoreInTheCurrentGamePlayer2().equals(ScoreInNormalGame.LOVE)) {
            score.setScoreInTheCurrentGamePlayer2("1");
        } else {
            if (Integer.valueOf(score.getScoreInTheCurrentGamePlayer2()) >= 6) {
                score.player2wonTheGame();
            } else {
                score.setScoreInTheCurrentGamePlayer2(String.valueOf(Integer.valueOf(score.getScoreInTheCurrentGamePlayer2()) + 1));

            }
        }
    }
}