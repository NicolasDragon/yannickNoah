package tennis.data.service;

import tennis.Score;
import tennis.Set;

public class GameService {

    private SetService setService = new SetService();

    private boolean hasPlayer2WonTheSet(Score score) {
        return hasPlayer2EnoughGamesToWinTheSet(score) || hasPlayer2WonTheSetOnTieBreak(score);
    }

    private boolean hasPlayer2WonTheSetOnTieBreak(Score score) {
        return score.getCurrentSet().getGamesWonByPlayer2() > 6;
    }

    private boolean hasPlayer2EnoughGamesToWinTheSet(Score score) {
        Set currentSet = score.getCurrentSet();
        return currentSet.getGamesWonByPlayer2() >= 6 && currentSet.getGamesWonByPlayer2() - currentSet.getGamesWonByPlayer1() >= 2;
    }

    public void player2wonTheGame(Score score) {
        Set currentSet = score.getCurrentSet();
        currentSet.setGamesWonByPlayer2(currentSet.getGamesWonByPlayer2() + 1);
        if (hasPlayer2WonTheSet(score)) {
            finishCurrentSet(score);
            startNewSet(score);
        }
        initScore(score);
    }

    public void initScore(Score score) {
        score.getCurrentGame().setScoreInTheCurrentGamePlayer1(ScoreInNormalGame.LOVE);
        score.getCurrentGame().setScoreInTheCurrentGamePlayer2(ScoreInNormalGame.LOVE);

    }

    public void startNewSet(Score score) {
        score.setCurrentSet(new Set());
    }

    private void finishCurrentSet(Score score) {
        score.getFinishedSets().add(score.getCurrentSet());
    }

    public void player1wonTheGame(Score score) {
        Set currentSet = score.getCurrentSet();
        currentSet.setGamesWonByPlayer1(currentSet.getGamesWonByPlayer1() + 1);
        if (hasPlayer1WonTheSet(score)) {
            setService.finishCurrentSet(score);
            setService.startNewSet(score);
        }
        initScore(score);
    }

    private boolean hasPlayer1WonTheSet(Score score) {
        Set currentSet = score.getCurrentSet();
        return currentSet.getGamesWonByPlayer1() >= 6
                && currentSet.getGamesWonByPlayer1() - currentSet.getGamesWonByPlayer2() >= 2
                || (currentSet.getGamesWonByPlayer1() > 6);
    }

}
