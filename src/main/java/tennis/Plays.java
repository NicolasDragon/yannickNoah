package tennis;

import java.util.List;

public class Plays {
    private final List<Boolean> plays;

    public Plays(List<Boolean> plays) {
        this.plays = plays;
    }

    public List<Boolean> getPlays() {
        return plays;
    }
}
