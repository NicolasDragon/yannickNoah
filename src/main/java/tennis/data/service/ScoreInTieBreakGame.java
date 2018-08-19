package tennis.data.service;

import tennis.Score;

public class ScoreInTieBreakGame {

    void computeScoreInTieBreakGameWhenPlayer1WonThePlay(Score score) {
        if (score.getScoreInTheCurrentGamePlayer1().equals(ScoreInNormalGame.LOVE)) {
            score.setScoreInTheCurrentGamePlayer1("1");
        } else {
            if (Integer.valueOf(score.getScoreInTheCurrentGamePlayer1()) >= 6) {
                score.player1wonTheGame();
            } else {
                increasePlayer1Score(score);

            }
        }
    }

    private void increasePlayer1Score(Score score) {
        Integer player1CurrentScore = Integer.valueOf(score.getScoreInTheCurrentGamePlayer1());
        int increasedPlayer1CurrentScore = player1CurrentScore + 1;
        score.setScoreInTheCurrentGamePlayer1(String.valueOf(increasedPlayer1CurrentScore));
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