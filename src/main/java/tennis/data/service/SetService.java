package tennis.data.service;

import tennis.Score;
import tennis.Set;

public class SetService {
    private static final int GAMES_TO_WIN_IN_TIE_BREAK = 7;
    private static final int GAMES_TO_WIN = 6;
    private static final int MINIMUM_GAMES_IN_ADVANCE_TO_WIN = 2;

    public void finishCurrentSet(Score score) {
        score.getFinishedSets().add(score.getCurrentSet());
    }

    public void startNewSet(Score score) {
        score.setCurrentSet(new Set());
    }

    public boolean hasPlayer2WonTheSet(Set currentSet) {
        return hasPlayer2EnoughGamesToWinTheSet(currentSet) || hasPlayerWonTheSetOnTieBreak(currentSet.getGamesWonByPlayer2());
    }

    private boolean hasPlayerWonTheSetOnTieBreak(int gamesWonByPlayer) {
        return gamesWonByPlayer == GAMES_TO_WIN_IN_TIE_BREAK;
    }

    private boolean hasPlayer2EnoughGamesToWinTheSet(Set currentSet) {
        return currentSet.getGamesWonByPlayer2() == GAMES_TO_WIN
                && currentSet.getGamesWonByPlayer2() - currentSet.getGamesWonByPlayer1() >= MINIMUM_GAMES_IN_ADVANCE_TO_WIN;
    }

    boolean hasPlayer1WonTheSet(Set currentSet) {
        return hasPlayer1Won6GamesWithTwoMoreThanPlayer2(currentSet.getGamesWonByPlayer1(), currentSet.getGamesWonByPlayer2())
                || hasPlayerWonTheSetOnTieBreak(currentSet.getGamesWonByPlayer1());
    }

    private boolean hasPlayer1Won6GamesWithTwoMoreThanPlayer2(int gamesWonByPlayer1, int gamesWonByPlayer2) {
        return gamesWonByPlayer1 >= GAMES_TO_WIN
                && gamesWonByPlayer1 - gamesWonByPlayer2 >= MINIMUM_GAMES_IN_ADVANCE_TO_WIN;
    }

}
