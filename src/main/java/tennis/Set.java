package tennis;

public class Set {
    int gamesWonByPlayer2;
    int gamesWonByPlayer1;

    public Set() {
    }

    public Set(int gamesInCurrentSetPlayer2, int gamesInCurrentSetPlayer1) {
        this.gamesWonByPlayer1 = gamesInCurrentSetPlayer1;
        this.gamesWonByPlayer2 = gamesInCurrentSetPlayer2;

    }

    public int getGamesWonByPlayer1() {
        return gamesWonByPlayer1;
    }

    public void setGamesWonByPlayer1(int gamesWonByPlayer1) {
        this.gamesWonByPlayer1 = gamesWonByPlayer1;
    }

    public int getGamesWonByPlayer2() {
        return gamesWonByPlayer2;
    }

    public void setGamesWonByPlayer2(int gamesWonByPlayer2) {
        this.gamesWonByPlayer2 = gamesWonByPlayer2;
    }
    public int getGamesInFinishedSetPlayer1() {
        return gamesWonByPlayer1;
    }
    public int getGameInFinishedSetPlayer2() {
        return gamesWonByPlayer2;
    }
}