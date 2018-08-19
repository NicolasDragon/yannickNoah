package tennis;

import tennis.data.service.GameService;
import tennis.formater.ScoreFormater;

import java.util.ArrayList;
import java.util.List;

/**
 * score object
 */
public class Score {
    //pas terrible
    private GameService gameService = new GameService();
    //current game
    private Game currentGame = new Game();
    //formatter to print our score
    private final ScoreFormater scoreFormater = new ScoreFormater();

    public Set getCurrentSet() {
        return currentSet;
    }

    private Set currentSet = new Set();

    //list of the finished set
    private List<Set> finishedSets = new ArrayList();


    public Score() {
        gameService.initScore(this);
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setScoreInTheCurrentGamePlayer1(String scoreInTheCurrentGamePlayer1) {
        currentGame.setScoreInTheCurrentGamePlayer1(scoreInTheCurrentGamePlayer1);
    }

    public void setScoreInTheCurrentGamePlayer2(String scoreInTheCurrentGamePlayer2) {
        currentGame.setScoreInTheCurrentGamePlayer2(scoreInTheCurrentGamePlayer2);
    }


    public int getGamesInCurrentSetPlayer1() {
        return currentSet.getGamesWonByPlayer1();
    }


    public int getGamesInCurrentSetPlayer2() {
        return currentSet.getGamesWonByPlayer2();
    }

    // question ne parle pas aux classes que tu ne connais pas ?
    public String getScoreInTheCurrentGamePlayer1() {
        return currentGame.getScoreInTheCurrentGamePlayer1();
    }

    public String getScoreInTheCurrentGamePlayer2() {
        return currentGame.getScoreInTheCurrentGamePlayer2();
    }


    //TODO a ameliorer. j'aime pas passer la référence
    @Override
    public String toString() {
        return scoreFormater.toString(this);
    }

    public List<Set> getFinishedSets() {
        return finishedSets;
    }


    public void setCurrentSet(Set currentSet) {
        this.currentSet = currentSet;
    }
}
