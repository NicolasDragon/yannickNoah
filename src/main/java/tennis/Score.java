package tennis;

import java.util.ArrayList;
import java.util.List;

/**
 * score object
 */
public class Score {

    //current game
    private ScoreInGame scoreInCurrentGame = new ScoreInGame();
    ;
    //formatter to print our score
    private final ScoreFormater scoreFormater = new ScoreFormater();

    private Set currentSet = new Set();

    private Set initSet() {
        return new Set();
    }

    //list of the finished set
    private List<Set> finishedSets = new ArrayList();


    public Score() {
        initScore();

    }

    public void setScoreInTheCurrentGamePlayer1(String scoreInTheCurrentGamePlayer1) {
        scoreInCurrentGame.setScoreInTheCurrentGamePlayer1(scoreInTheCurrentGamePlayer1);
    }

    public void setScoreInTheCurrentGamePlayer2(String scoreInTheCurrentGamePlayer2) {
        scoreInCurrentGame.setScoreInTheCurrentGamePlayer2(scoreInTheCurrentGamePlayer2);
    }


    public int getGamesInCurrentSetPlayer1() {
        return currentSet.getGamesWonByPlayer1();
    }


    public int getGamesInCurrentSetPlayer2() {
        return currentSet.getGamesWonByPlayer2();
    }

    private void initScore() {
        this.scoreInCurrentGame.setScoreInTheCurrentGamePlayer1(ScoreInNormalGame.LOVE);
        this.scoreInCurrentGame.setScoreInTheCurrentGamePlayer2(ScoreInNormalGame.LOVE);

    }

    // question ne parle pas aux classes que tu ne connais pas ?
    public String getScoreInTheCurrentGamePlayer1() {
        return scoreInCurrentGame.getScoreInTheCurrentGamePlayer1();
    }

    public String getScoreInTheCurrentGamePlayer2() {
        return scoreInCurrentGame.getScoreInTheCurrentGamePlayer2();
    }

    public void player2wonTheGame() {
        currentSet.setGamesWonByPlayer2(currentSet.getGamesWonByPlayer2() + 1);
        if (hasPlayer2WonTheSet()) {
            finishCurrentSet();
            startNewSet();
        }
        initScore();
    }

    private void startNewSet() {
        currentSet = new Set();
    }

    private void finishCurrentSet() {
        getFinishedSets().add(currentSet);
    }

    private boolean hasPlayer2WonTheSet() {
        return hasPlayer2EnoughGamesToWinTheSet() || hasPlayer2WonTheSetOnTieBreak();
    }

    private boolean hasPlayer2WonTheSetOnTieBreak() {
        return currentSet.getGamesWonByPlayer2() > 6;
    }

    private boolean hasPlayer2EnoughGamesToWinTheSet() {
        return currentSet.getGamesWonByPlayer2() >= 6 && currentSet.getGamesWonByPlayer2() - currentSet.getGamesWonByPlayer1() >= 2;
    }

    public void player1wonTheGame() {
        currentSet.setGamesWonByPlayer1(currentSet.getGamesWonByPlayer1() + 1);
        if (hasPlayer1WonTheSet()) {
            finishCurrentSet();
            startNewSet();
        }
        initScore();
    }

    private boolean hasPlayer1WonTheSet() {
        return currentSet.getGamesWonByPlayer1() >= 6 && currentSet.getGamesWonByPlayer1() - currentSet.getGamesWonByPlayer2() >= 2 || (currentSet.getGamesWonByPlayer1() > 6);
    }

    //TODO a ameliorer. j'aime pas passer la référence
    @Override
    public String toString() {
        return scoreFormater.toString(this);
    }

    public List<Set> getFinishedSets() {
        return finishedSets;
    }


}
