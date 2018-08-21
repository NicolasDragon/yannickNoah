package tennis;

public class Game {

    private String scoreInTheCurrentGamePlayer1 = "love";
    private String scoreInTheCurrentGamePlayer2 = "love";

    public void setScoreInTheCurrentGamePlayer1(String scoreInTheCurrentGamePlayer1) {
        this.scoreInTheCurrentGamePlayer1 = scoreInTheCurrentGamePlayer1;
    }

    public void setScoreInTheCurrentGamePlayer2(String scoreInTheCurrentGamePlayer2) {
        this.scoreInTheCurrentGamePlayer2 = scoreInTheCurrentGamePlayer2;
    }

    public String getScoreInTheCurrentGamePlayer1() {
        return scoreInTheCurrentGamePlayer1;
    }

    public String getScoreInTheCurrentGamePlayer2() {
        return scoreInTheCurrentGamePlayer2;
    }
}