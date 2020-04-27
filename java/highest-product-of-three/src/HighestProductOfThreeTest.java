import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighestProductOfThreeTest {

    @Test
    void calcHighestProduct() {

        HighestProductOfThree calc = new HighestProductOfThree();

        int[] arrayOfInts = new int[] {1,2,3,4,5,6};
        Assertions.assertEquals(120, calc.calcHighestProduct(arrayOfInts));

        arrayOfInts = new int[] {1,2,3,4,-10,-10};
        Assertions.assertEquals(400, calc.calcHighestProduct(arrayOfInts));

    }
}