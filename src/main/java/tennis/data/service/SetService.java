package tennis.data.service;

import tennis.Score;
import tennis.Set;

public class SetService {


    public void finishCurrentSet(Score score) {
        score.getFinishedSets().add(score.getCurrentSet());
    }

    public void startNewSet(Score score) {
        score.setCurrentSet(new Set());
    }
}
