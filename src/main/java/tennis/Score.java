package tennis;

import java.util.ArrayList;
import java.util.List;

public class Score {

    private final ScoreInGame scoreInCurrentGame = new ScoreInGame();

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

    public String getScoreInTheCurrentGamePlayer1() {
        return scoreInCurrentGame.getScoreInTheCurrentGamePlayer1();
    }

    public String getScoreInTheCurrentGamePlayer2() {
        return scoreInCurrentGame.getScoreInTheCurrentGamePlayer2();
    }

    public void player2wonTheGame() {
        setGamesInCurrentSetPlayer2(getGamesInCurrentSetPlayer2() + 1);
        if (getGamesInCurrentSetPlayer2() >= 6 && getGamesInCurrentSetPlayer2() - getGamesInCurrentSetPlayer1() >= 2) {
            getFinishedSets().add(new FinishedSet(getGamesInCurrentSetPlayer2(), getGamesInCurrentSetPlayer1()));
            setGamesInCurrentSetPlayer1(0);
            setGamesInCurrentSetPlayer2(0);
        }
        initScore();
    }

    public void player1wonTheGame() {
        setGamesInCurrentSetPlayer1(getGamesInCurrentSetPlayer1() + 1);
        if (getGamesInCurrentSetPlayer1() >= 6 && getGamesInCurrentSetPlayer1() - getGamesInCurrentSetPlayer2() >= 2||(getGamesInCurrentSetPlayer1() > 6)) {
            getFinishedSets().add(new FinishedSet(getGamesInCurrentSetPlayer2(), getGamesInCurrentSetPlayer1()));
            setGamesInCurrentSetPlayer1(0);
            setGamesInCurrentSetPlayer2(0);
        }
        initScore();
    }

    @Override
    public String toString() {
        StringBuilder resultat = new StringBuilder();
        addPreviousSetsResults(resultat);
        if (!scoreInCurrentGame.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase("love")
                && scoreInCurrentGame.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase(scoreInCurrentGame.getScoreInTheCurrentGamePlayer2())) {
            resultat.append(gamesInCurrentSetPlayer1 + "|" + gamesInCurrentSetPlayer2 + " " + scoreInCurrentGame.getScoreInTheCurrentGamePlayer1() + "A");
            return resultat.toString();
        }
        if (scoreInCurrentGame.getScoreInTheCurrentGamePlayer1().equalsIgnoreCase("advantage in")) {
            resultat.append(gamesInCurrentSetPlayer1 + "|" + gamesInCurrentSetPlayer2 + " " + scoreInCurrentGame.getScoreInTheCurrentGamePlayer1());
            return resultat.toString();
        } else if (scoreInCurrentGame.getScoreInTheCurrentGamePlayer2().equalsIgnoreCase("advantage out")) {
            resultat.append(gamesInCurrentSetPlayer1 + "|" + gamesInCurrentSetPlayer2 + " " + scoreInCurrentGame.getScoreInTheCurrentGamePlayer2());
            return resultat.toString();
        }
        if (finishedSets.stream().filter(x -> x.getGameInSetPlayer2() - x.getGamePlayer1() >= 1 && x.getGameInSetPlayer2() >= 6).count() == 3) {
            return resultat.append("player 2 won").toString();
        } else if (finishedSets.stream().filter(x -> x.getGamePlayer1() - x.getGameInSetPlayer2() >= 1 && x.getGamePlayer1() >= 6).count() == 3) {
            return resultat.append("player 1 won").toString();
        }
        return resultat.append(gamesInCurrentSetPlayer1 + "|" + gamesInCurrentSetPlayer2 + " " + scoreInCurrentGame.getScoreInTheCurrentGamePlayer1() + ":" + scoreInCurrentGame.getScoreInTheCurrentGamePlayer2()).toString();
    }

    private void addPreviousSetsResults(StringBuilder resultat) {
        for (FinishedSet finishedSet : finishedSets) {
            resultat.append(finishedSet.getGamePlayer1() + "|" + finishedSet.getGameInSetPlayer2() + " ");
        }
    }
}
