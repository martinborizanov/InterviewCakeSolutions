import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfAllOtherNumbersTest {

    @org.junit.jupiter.api.Test
    void getProductsOfAllIntsExceptAtIndex() {

        ProductOfAllOtherNumbers calc = new ProductOfAllOtherNumbers();

        int[] RV = calc.getProductsOfAllIntsExceptAtIndex(new int[] {1,2,3,4});
        Assert.assertArrayEquals(new int[] {24,12,8,6}, RV);

    }
}