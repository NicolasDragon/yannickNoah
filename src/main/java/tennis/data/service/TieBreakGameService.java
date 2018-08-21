package tennis.data.service;

import tennis.Score;

public class TieBreakGameService extends GameService {


    void computeScoreInTieBreakGameWhenPlayer1WonThePlay(Score score) {
        if (score.getScoreInTheCurrentGamePlayer1().equals(StandardGameService.LOVE)) {
            score.setScoreInTheCurrentGamePlayer1("1");
        } else {
            //TODO améliorer cett conversion
            //TODO améliorer ces magics numbers
            //TODO  la condition n'est pas bonne, il faut 2 coups d'écart
            if (Integer.valueOf(score.getScoreInTheCurrentGamePlayer1()) >= 6) {
                changerScoreWhenPlayer1WonTheGame(score);
            } else {
                score.setScoreInTheCurrentGamePlayer1(String.valueOf(increasePlayer1Score(score)));

            }
        }
    }

    private int increasePlayer1Score(Score score) {
        Integer player1CurrentScore = Integer.valueOf(score.getScoreInTheCurrentGamePlayer1());
        return player1CurrentScore + 1;
    }

    void computeScoreInTieBreakGameWhenPlayer2WonThePlay(Score score) {
        if (score.getScoreInTheCurrentGamePlayer2().equals(StandardGameService.LOVE)) {
            score.setScoreInTheCurrentGamePlayer2("1");
        } else {
            if (Integer.valueOf(score.getScoreInTheCurrentGamePlayer2()) >= 6) {
                changeScoreWhenPlayer2WonTheGame(score, score.getCurrentSet());
            } else {
                score.setScoreInTheCurrentGamePlayer2(String.valueOf(Integer.valueOf(score.getScoreInTheCurrentGamePlayer2()) + 1));

            }
        }
    }
}