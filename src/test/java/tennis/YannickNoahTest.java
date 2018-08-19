package tennis;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import tennis.YannickNoah;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Boolean.*;

@RunWith(DataProviderRunner.class)
public class YannickNoahTest {


    public static final Boolean[] FIRST_PLAYER_GAME = {TRUE, TRUE, TRUE, TRUE};
    private YannickNoah yannickNoah;

    @Before
    public void setUp() {
        yannickNoah = new YannickNoah();
    }


    @Test
    @UseDataProvider(("datas"))
    public void compteScoreTest(List<Boolean> plays,
                                String expectedScore,
                                String scenarioName) {
        //WHEN
        String result = yannickNoah.computeScore(new ArrayList<>(plays));

        //THEN
        Assert.assertEquals(scenarioName, expectedScore, result);

    }


    @DataProvider
    public static Object[][] datas() {
        return new Object[][]{
                {Collections.emptyList(), "0|0 love:love", "game init"},
                {Arrays.asList(TRUE), "0|0 15:love", "first player scores once"},
                {Arrays.asList(FALSE), "0|0 love:15", "second player scores"},
                {Arrays.asList(FALSE, TRUE), "0|0 15A", "two players score once"},
                {Arrays.asList(TRUE, FALSE), "0|0 15A", "two players score once"},
                {Arrays.asList(TRUE, TRUE), "0|0 30:love", "first player scores twice"},
                {Arrays.asList(FALSE, FALSE), "0|0 love:30", "second player scores twice"},
                {Arrays.asList(FALSE, FALSE, FALSE), "0|0 love:40", "second player scores three times"},
                {Arrays.asList(TRUE, TRUE, TRUE), "0|0 40:love", "first player scores three times"},
                {Arrays.asList(TRUE, TRUE, TRUE, FALSE, FALSE, FALSE, FALSE), "0|0 advantage out", "second player has advantage"},
                {Arrays.asList(TRUE, TRUE, TRUE, FALSE, FALSE, FALSE, TRUE), "0|0 advantage in", "first player has advantage"},
                {Arrays.asList(FALSE, FALSE, TRUE, TRUE), "0|0 30A", ""},
                {Arrays.asList(FALSE, FALSE, FALSE, TRUE, TRUE, TRUE), "0|0 40A", ""},
                {Arrays.asList(FALSE, FALSE, TRUE, TRUE, TRUE), "0|0 40:30", ""},
                {Arrays.asList(TRUE, TRUE, TRUE, TRUE), "1|0 love:love", ""},
                {Arrays.asList(TRUE, TRUE, TRUE, TRUE, TRUE), "1|0 15:love", ""},
                {Arrays.asList(TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE), "2|0 love:love", "2 games to zero"},
                {Arrays.asList(FALSE, FALSE, FALSE, FALSE, FALSE, FALSE, FALSE, FALSE), "0|2 love:love", "2 games to zero"},
                {Arrays.asList(TRUE, TRUE, FALSE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE), "2|0 love:love", "2 games to zero"},
                {createPlays(TRUE, 16), "4|0 love:love", "2 games to zero"},
                {createPlays(TRUE, 28), "6|0 1|0 love:love", "2 games to zero"},
                {createPlays(TRUE, 72), "6|0 6|0 6|0 player 1 won", "2 games to zero"},
                {createPlays(FALSE, 28), "0|6 0|1 love:love", "1 set and 1 games to zero"},
                {createPlays(FALSE, 48), "0|6 0|6 0|0 love:love", "2  sets to zero"},
                {createPlays(FALSE, 72), "0|6 0|6 0|6 player 2 won", "2 games to zero"},
                {Arrays.asList(TRUE, TRUE, TRUE, FALSE, FALSE, FALSE, FALSE, FALSE), "0|1 love:love", "second player has advantage"},
                {Arrays.asList(TRUE, TRUE, TRUE, FALSE, FALSE, FALSE, TRUE, TRUE), "1|0 love:love", "second player has advantage"},
                {createTieBreakFirstPlayer(), "7|6 0|0 love:love", "first player won the first set on tie break"},
                {createTieBreakSecondPlayer(), "6|7 0|0 love:love", "second  player won the first set on tie break"},
        };
    }

    public static List createTieBreakFirstPlayer() {
        // 5-0
        List<Boolean> plays = createPlays(TRUE, 20);
        // 5-5
        plays.addAll(createPlays(FALSE, 20));
        //6-5
        plays.addAll(createPlays(TRUE, 4));
        //6-6
        plays.addAll(createPlays(FALSE, 4));
        //7-6
        //facon différente de compter le score ici!
        //premier à 7 avec 2 points d'écart
        plays.addAll(createPlays(TRUE, 7));
//        plays.addAll(createPlays(TRUE, 4));
        return plays;
    }



    public static List createTieBreakSecondPlayer() {
        // 0-5
        List<Boolean> plays = createPlays(FALSE, 20);
        // 5-5
        plays.addAll(createPlays(TRUE, 20));
        //5-6
        plays.addAll(createPlays(FALSE, 4));
        //6-6
        plays.addAll(createPlays(TRUE, 4));
        //6-7
        //facon différente de compter le score ici!
        //premier à 7 avec 2 points d'écart
        plays.addAll(createPlays(FALSE, 7));
//        plays.addAll(createPlays(TRUE, 4));
        return plays;
    }

    private static List<Boolean> createPlays(Boolean value, int number) {
        return Stream.generate(() -> value).limit(number).collect(Collectors.toList());
    }
}

