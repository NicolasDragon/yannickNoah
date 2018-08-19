package tennis.data.service;

import tennis.Score;
import tennis.data.service.ScoreInNormalGame;
import tennis.data.service.ScoreInTieBreakGame;

import java.util.List;

public class ComputeTennisScore {


    private final ScoreInTieBreakGame scoreInTieBreakGame = new ScoreInTieBreakGame();
    final ScoreInNormalGame scoreInNormalGame = new ScoreInNormalGame();


    public String computeScore(List<Boolean> plays) {
        return computeScoreRecursive(plays, new Score());
    }


    private String computeScoreRecursive(List<Boolean> plays, Score score) {
        if (plays.size() == 0) {
            return score.toString();
        }
        computeNewScoreAfterThisPlay(score, plays.get(0));
        plays.remove(0);
        return computeScoreRecursive(plays, score);
    }

    //q travail sur l'objet direct ? ou bien copie puis retour ?
    private void computeNewScoreAfterThisPlay(Score score, Boolean play) {
        if (play) {
            computeScoreWhenFirstPlayerWonTheBall(score);
        } else {
            compteScoreWhenSecondPlayerWonTheBall(score);
        }
    }

    private void compteScoreWhenSecondPlayerWonTheBall(Score score) {
        if (isTieBreak(score)) {
            scoreInTieBreakGame.computeScoreInTieBreakGameWhenPlayer2WonThePlay(score);
        } else {
            scoreInNormalGame.computeScoreInNormalGameWhenPlayer2WonTheGame(score);

        }
    }

    private void computeScoreWhenFirstPlayerWonTheBall(Score score) {
        if (isTieBreak(score)) {
            scoreInTieBreakGame.computeScoreInTieBreakGameWhenPlayer1WonThePlay(score);
        } else {
            scoreInNormalGame.computeScoreInNormalGameWhenPlayer1WonTheGame(score);
        }
    }

    private boolean isTieBreak(Score score) {
        return score.getGamesInCurrentSetPlayer1() == 6 && score.getGamesInCurrentSetPlayer2() == 6;
    }
}
