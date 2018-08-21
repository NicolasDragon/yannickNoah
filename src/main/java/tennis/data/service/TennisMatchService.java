package tennis.data.service;

import tennis.Score;
import tennis.Set;

import java.util.List;
import java.util.function.Predicate;

public class TennisMatchService {

    public static final int WON_SET_NUMBER_TO_WIN = 3;
    private final TieBreakGameService tieBreakGameService = new TieBreakGameService();
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
        if (tieBreakGameService.isTieBreak(score.getGamesInCurrentSetPlayer1(), score.getGamesInCurrentSetPlayer2())) {
            tieBreakGameService.computeScoreInTieBreakGameWhenPlayer2WonThePlay(score);
        } else {
            standardGameService.computeScoreInNormalGameWhenPlayer2WonTheGame(score);

        }
    }

    private void computeScoreWhenFirstPlayerWonTheBall(Score score) {
        if (tieBreakGameService.isTieBreak(score.getGamesInCurrentSetPlayer1(), score.getGamesInCurrentSetPlayer2())) {
            tieBreakGameService.computeScoreInTieBreakGameWhenPlayer1WonThePlay(score);
        } else {
            standardGameService.computeScoreInNormalGameWhenPlayer1WonTheGame(score);
        }
    }

    public boolean hasPlayer1WonTheMatch(List<Set> finishedSets) {
        return finishedSets.stream().filter(x -> x.getGamesInFinishedSetPlayer1() - x.getGameInFinishedSetPlayer2() >= 1
                && x.getGamesInFinishedSetPlayer1() >= 6).count() == WON_SET_NUMBER_TO_WIN;
    }

    public boolean hasPlayer2WonTheMatch(List<Set> finishedSets) {
        return finishedSets.stream().filter(x -> x.getGameInFinishedSetPlayer2() - x.getGamesInFinishedSetPlayer1() >= 1
                && x.getGameInFinishedSetPlayer2() >= 6).count() == WON_SET_NUMBER_TO_WIN;
    }

}
