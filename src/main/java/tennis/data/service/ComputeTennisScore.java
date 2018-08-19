package tennis.data.service;

import tennis.Score;

import java.util.List;

public class ComputeTennisScore {


    private final TieBreakGame tieBreakGame = new TieBreakGame();
    final StandardGameService standardGameService = new StandardGameService();


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
        if (isTieBreak(score.getGamesInCurrentSetPlayer1(), score.getGamesInCurrentSetPlayer2())) {
            tieBreakGame.computeScoreInTieBreakGameWhenPlayer2WonThePlay(score);
        } else {
            standardGameService.computeScoreInNormalGameWhenPlayer2WonTheGame(score);

        }
    }

    private void computeScoreWhenFirstPlayerWonTheBall(Score score) {
        if (isTieBreak(score.getGamesInCurrentSetPlayer1(), score.getGamesInCurrentSetPlayer2())) {
            tieBreakGame.computeScoreInTieBreakGameWhenPlayer1WonThePlay(score);
        } else {
            standardGameService.computeScoreInNormalGameWhenPlayer1WonTheGame(score);
        }
    }

    private boolean isTieBreak(int gamesInCurrentSetPlayer1, int gamesInCurrentSetPlayer2) {
        return gamesInCurrentSetPlayer1 == 6 && gamesInCurrentSetPlayer2 == 6;
    }
}
