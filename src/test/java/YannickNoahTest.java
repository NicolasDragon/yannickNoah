import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import tennis.Plays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Boolean.*;

@RunWith(DataProviderRunner.class)
public class YannickNoahTest {


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
                {Collections.emptyList(), "love:love", "game init"},
                {Arrays.asList(TRUE), "15:love", "first player scores once"},
                {Arrays.asList(FALSE), "love:15", "second player scores"},
                {Arrays.asList(FALSE, TRUE), "15A", "two players score once"},
                {Arrays.asList(TRUE, FALSE), "15A", "two players score once"},
                {Arrays.asList(TRUE, TRUE), "30:love", "first player scores twice"},
                {Arrays.asList(FALSE, FALSE), "love:30", "second player scores twice"},
                {Arrays.asList(FALSE, FALSE,FALSE), "love:40", "second player scores three times"},
                {Arrays.asList(TRUE, TRUE,TRUE), "40:love", "first player scores three times"},
                {Arrays.asList(TRUE, TRUE, TRUE, FALSE, FALSE, FALSE, FALSE), "advantage out", "second player has advantage"},
                {Arrays.asList(TRUE, TRUE, TRUE, FALSE, FALSE, FALSE, TRUE), "advantage in", "first player has advantage"},
                {Arrays.asList(FALSE, FALSE, TRUE, TRUE), "30A", ""},
                {Arrays.asList(FALSE, FALSE,FALSE,TRUE, TRUE, TRUE), "40A", ""},
                {Arrays.asList(FALSE, FALSE,TRUE, TRUE, TRUE), "40:30", ""},
//                {Arrays.asList( TRUE, TRUE,TRUE, TRUE), "1|0 love:love", ""},
        };
    }
}

