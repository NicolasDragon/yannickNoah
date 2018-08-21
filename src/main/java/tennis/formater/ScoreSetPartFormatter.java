package tennis.formater;

import tennis.Set;

import java.util.List;

public class ScoreSetPartFormatter {
    public ScoreSetPartFormatter() {
    }

    public void addPreviousSetsResults(StringBuilder resultat, List<Set> finishedSets) {
        for (Set finishedSet : finishedSets) {
            resultat.append(finishedSet.getGamesInFinishedSetPlayer1() + ScoreFormater.TILT + finishedSet.getGameInFinishedSetPlayer2() + ScoreFormater.SPACE);
        }
    }
}