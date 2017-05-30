import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Western-Co on 30.05.2017.
 */
public class TestStatistic {
    private ArrayList<Integer> arr = new ArrayList<>();

    @Before
    public void initArray() {
        for (int i = 1; i <= 5; i++) {
            arr.add(i);
        }
    }

    @Test
    public void testMean() throws Exception {
        assertEquals(3.0, HackerRankStatistics.findMean(arr), 0.01);
    }

}
