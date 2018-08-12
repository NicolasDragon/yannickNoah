package tennis;

public class Score {

    public void setScorePlayer1(String scorePlayer1) {
        this.scorePlayer1 = scorePlayer1;
    }

    public void setScorePlayer2(String scorePlayer2) {
        this.scorePlayer2 = scorePlayer2;
    }

    private String scorePlayer1;
    private String scorePlayer2;

    public Score(String scorePlayer1, String scorePlayer2) {
        this.scorePlayer1 = scorePlayer1;
        this.scorePlayer2 = scorePlayer2;
    }

    public String getScorePlayer1() {
        return scorePlayer1;
    }

    public String getScorePlayer2() {
        return scorePlayer2;
    }

    @Override
    public String toString() {
        if (!scorePlayer1.equalsIgnoreCase("love")&&scorePlayer1.equalsIgnoreCase(scorePlayer2)) {
            return scorePlayer1 + "A";
        }
        if(scorePlayer1.equalsIgnoreCase("advantage in")){
            return scorePlayer1;
        }else if(scorePlayer2.equalsIgnoreCase("advantage out")){
            return scorePlayer2;
        }
        return scorePlayer1 + ":" + scorePlayer2;
    }
}
