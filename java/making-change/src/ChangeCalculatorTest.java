
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChangeCalculatorTest {

    @Test
    void sampleInputTest() {

        int actual = new ChangeCalculator().changePossibilities(4, new Integer[] {1,2,3});
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    void modifiedSampleInputTest() {

        int actual = new ChangeCalculator().changePossibilities(4, new Integer[] {1,2,3,4});
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    void cantMakeTheAmount() {

        int actual = new ChangeCalculator().changePossibilities(4, new Integer[] {5});
        int expected = 0;

        assertEquals(expected, actual);
    }

}