package tennis.data.service;

import tennis.Game;
import tennis.Score;
import tennis.Set;
import tennis.TieBreakGame;

public class GameService {
    private static final int GAME_COUNT_IN_TIE_BREAK = 6;
    private SetService setService = new SetService();


    public void changeScoreWhenPlayer2WonTheGame(Score score, Set currentSet) {
        currentSet.setGamesWonByPlayer2(incrementGameScorePlayer(currentSet.getGamesWonByPlayer2()));
        if (setService.hasPlayer2WonTheSet(currentSet)) {
            setService.finishCurrentSet(score);
            setService.startNewSet(score);
        }
        score.setCurrentGame(startNewGame(score.getGamesInCurrentSetPlayer1(), score.getGamesInCurrentSetPlayer2()));
    }

    private int incrementGameScorePlayer(int gamesWonByPlayer) {
        return gamesWonByPlayer + 1;
    }

    public boolean isTieBreak(int gamesInCurrentSetPlayer1, int gamesInCurrentSetPlayer2) {
        return gamesInCurrentSetPlayer1 == GAME_COUNT_IN_TIE_BREAK && gamesInCurrentSetPlayer2 == GAME_COUNT_IN_TIE_BREAK;
    }

    private Game startNewGame(int gamesInCurrentSetPlayer1, int gamesInCurrentSetPlayer2) {
        if (isTieBreak(gamesInCurrentSetPlayer1, gamesInCurrentSetPlayer2)) {
            return new TieBreakGame();
        } else {
            return new  Game();
        }

    }

    public void changerScoreWhenPlayer1WonTheGame(Score score) {
        Set currentSet = score.getCurrentSet();
        currentSet.setGamesWonByPlayer1(incrementGameScorePlayer(currentSet.getGamesWonByPlayer1()));
        if (setService.hasPlayer1WonTheSet(score.getCurrentSet())) {
            setService.finishCurrentSet(score);
            setService.startNewSet(score);
        }
        score.setCurrentGame(startNewGame(score.getGamesInCurrentSetPlayer1(), score.getGamesInCurrentSetPlayer2()));
    }

}
