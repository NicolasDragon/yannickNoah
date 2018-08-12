package tennis;

public class Score {

    public void setScoreInTheCurrentGamePlayer1(String scoreInTheCurrentGamePlayer1) {
        this.scoreInTheCurrentGamePlayer1 = scoreInTheCurrentGamePlayer1;
    }

    public void setScoreInTheCurrentGamePlayer2(String scoreInTheCurrentGamePlayer2) {
        this.scoreInTheCurrentGamePlayer2 = scoreInTheCurrentGamePlayer2;
    }

    private int gamesPlayer1;

    public int getGamesPlayer1() {
        return gamesPlayer1;
    }

    public void setGamesPlayer1(int gamesPlayer1) {
        this.gamesPlayer1 = gamesPlayer1;
    }

    public int getGamesPlayer2() {
        return gamesPlayer2;
    }

    public void setGamesPlayer2(int gamesPlayer2) {
        this.gamesPlayer2 = gamesPlayer2;
    }

    private int gamesPlayer2;

    private String scoreInTheCurrentGamePlayer1;
    private String scoreInTheCurrentGamePlayer2;

    public Score(String scoreInTheCurrentGamePlayer1, String scoreInTheCurrentGamePlayer2) {
        this.scoreInTheCurrentGamePlayer1 = scoreInTheCurrentGamePlayer1;
        this.scoreInTheCurrentGamePlayer2 = scoreInTheCurrentGamePlayer2;
    }

    public String getScoreInTheCurrentGamePlayer1() {
        return scoreInTheCurrentGamePlayer1;
    }

    public String getScoreInTheCurrentGamePlayer2() {
        return scoreInTheCurrentGamePlayer2;
    }

    @Override
    public String toString() {
        if (!scoreInTheCurrentGamePlayer1.equalsIgnoreCase("love") && scoreInTheCurrentGamePlayer1.equalsIgnoreCase(scoreInTheCurrentGamePlayer2)) {
            return gamesPlayer1 + "|" + gamesPlayer2 +" "+ scoreInTheCurrentGamePlayer1 + "A";
        }
        if (scoreInTheCurrentGamePlayer1.equalsIgnoreCase("advantage in")) {
            return gamesPlayer1 + "|" + gamesPlayer2 +" "+ scoreInTheCurrentGamePlayer1;
        } else if (scoreInTheCurrentGamePlayer2.equalsIgnoreCase("advantage out")) {
            return gamesPlayer1 + "|" + gamesPlayer2 +" "+ scoreInTheCurrentGamePlayer2;
        }
        return gamesPlayer1 + "|" + gamesPlayer2 +" "+ scoreInTheCurrentGamePlayer1 + ":" + scoreInTheCurrentGamePlayer2;
    }
}
