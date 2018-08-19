package tennis.data.service;

import tennis.Score;

public class TieBreakGame {

    private GameService gameService = new GameService();

    void computeScoreInTieBreakGameWhenPlayer1WonThePlay(Score score) {
        if (score.getScoreInTheCurrentGamePlayer1().equals(StandardGameService.LOVE)) {
            score.setScoreInTheCurrentGamePlayer1("1");
        } else {
            //TODO améliorer cett conversion
            //TODO améliorer ces magics numbers
            //TODO  la condition n'est pas bonne, il faut 2 coups d'écart
            if (Integer.valueOf(score.getScoreInTheCurrentGamePlayer1()) >= 6) {
                gameService.player1wonTheGame(score);
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
        if (score.getScoreInTheCurrentGamePlayer2().equals(StandardGameService.LOVE)) {
            score.setScoreInTheCurrentGamePlayer2("1");
        } else {
            if (Integer.valueOf(score.getScoreInTheCurrentGamePlayer2()) >= 6) {
                gameService.player2wonTheGame(score);
            } else {
                score.setScoreInTheCurrentGamePlayer2(String.valueOf(Integer.valueOf(score.getScoreInTheCurrentGamePlayer2()) + 1));

            }
        }
    }
}