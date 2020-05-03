import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TempTrackerTest {

    @Test
    void basicTest() {

        int[] values = new int[]{1,2,3,4,5,6,7,8,9};
        TempTracker TT = new TempTracker();

        for(int value : values) TT.insert(value);

        Assertions.assertEquals(1, TT.getMin());
        Assertions.assertEquals(9, TT.getMax());
        Assertions.assertEquals(5, TT.getMean());
    }

}