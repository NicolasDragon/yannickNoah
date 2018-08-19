package tennis;

import java.util.ArrayList;
import java.util.List;

public class Score {

    private final ScoreInGame scoreInCurrentGame = new ScoreInGame();
    private final ScoreFormater scoreFormater = new ScoreFormater();

    public List<FinishedSet> getFinishedSets() {
        return finishedSets;
    }

    private List<FinishedSet> finishedSets = new ArrayList();
    private int gamesInCurrentSetPlayer2;
    private int gamesInCurrentSetPlayer1;


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
        return gamesInCurrentSetPlayer1;
    }

    public void setGamesInCurrentSetPlayer1(int gamesInCurrentSetPlayer1) {
        this.gamesInCurrentSetPlayer1 = gamesInCurrentSetPlayer1;
    }

    public int getGamesInCurrentSetPlayer2() {
        return gamesInCurrentSetPlayer2;
    }

    public void setGamesInCurrentSetPlayer2(int gamesInCurrentSetPlayer2) {
        this.gamesInCurrentSetPlayer2 = gamesInCurrentSetPlayer2;
    }


    private void initScore() {
        this.scoreInCurrentGame.setScoreInTheCurrentGamePlayer1("love");
        this.scoreInCurrentGame.setScoreInTheCurrentGamePlayer2("love");
    }
// question ne parle pas aux classes que tu ne connais pas ?
    public String getScoreInTheCurrentGamePlayer1() {
        return scoreInCurrentGame.getScoreInTheCurrentGamePlayer1();
    }

    public String getScoreInTheCurrentGamePlayer2() {
        return scoreInCurrentGame.getScoreInTheCurrentGamePlayer2();
    }

    public void player2wonTheGame() {
        setGamesInCurrentSetPlayer2(getGamesInCurrentSetPlayer2() + 1);
        if (hasPlayer2WonTheSet()) {
            setCurrentSetFinished();
            startNewSet();
        }
        initScore();
    }

    private void startNewSet() {
        setGamesInCurrentSetPlayer1(0);
        setGamesInCurrentSetPlayer2(0);
    }

    private void setCurrentSetFinished() {
        getFinishedSets().add(new FinishedSet(getGamesInCurrentSetPlayer2(), getGamesInCurrentSetPlayer1()));
    }

    private boolean hasPlayer2WonTheSet() {
        return hasPlayer2EnoughGamesToWinTheSet() || hasPlayer2WonTheSetOnTieBreak();
    }

    private boolean hasPlayer2WonTheSetOnTieBreak() {
        return getGamesInCurrentSetPlayer2() > 6;
    }

    private boolean hasPlayer2EnoughGamesToWinTheSet() {
        return getGamesInCurrentSetPlayer2() >= 6 && getGamesInCurrentSetPlayer2() - getGamesInCurrentSetPlayer1() >= 2;
    }

    public void player1wonTheGame() {
        setGamesInCurrentSetPlayer1(getGamesInCurrentSetPlayer1() + 1);
        if (hasPlayer1WonTheSet()) {
            setCurrentSetFinished();
            startNewSet();
        }
        initScore();
    }

    private boolean hasPlayer1WonTheSet() {
        return getGamesInCurrentSetPlayer1() >= 6 && getGamesInCurrentSetPlayer1() - getGamesInCurrentSetPlayer2() >= 2||(getGamesInCurrentSetPlayer1() > 6);
    }

    //TODO a ameliorer. j'aime pas passer la référence
    @Override
    public String toString() {
        return scoreFormater.toString(this);
    }


}
