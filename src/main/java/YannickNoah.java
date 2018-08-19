import tennis.Score;

import java.util.Arrays;
import java.util.List;

public class YannickNoah {


    private final ScoreInTieBreakGame scoreInTieBreakGame = new ScoreInTieBreakGame();
    final ScoreInNormalGame scoreInNormalGame = new ScoreInNormalGame();


    public String computeScore(List<Boolean> plays) {
        return compteScoreRecursive(plays, new Score());
    }


    private String compteScoreRecursive(List<Boolean> plays, Score score) {
        if (plays.size() == 0) {
            return score.toString();
        }
        //joueur 1 a gagné
        if (plays.get(0)) {
            computeScoreWhenFirstPlayerWonTheBall(score);
        } else {
            compteScoreWhenSecondPlayerWonTheBall(score);
        }
        plays.remove(0);
        return compteScoreRecursive(plays, score);
    }

    private void compteScoreWhenSecondPlayerWonTheBall(Score score) {
        if (isTieBreak(score)) {
            scoreInTieBreakGame.computeScoreInTieBreakGameWhenPlayer2WonThePlay(score);
        }else{
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
