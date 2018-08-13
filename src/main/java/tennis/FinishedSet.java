package tennis;

public class FinishedSet {
    private int gamePlayer2;
    private int gamePlayer1;
    public int getGameInSetPlayer2() {
        return gamePlayer2;
    }

    public void setGamePlayer2(int gamePlayer2) {
        this.gamePlayer2 = gamePlayer2;
    }

    public FinishedSet(int gamePlayer2, int gamePlayer1) {
        this.gamePlayer2 = gamePlayer2;
        this.gamePlayer1 = gamePlayer1;
    }

    public int getGamePlayer1() {
        return gamePlayer1;
    }


}
