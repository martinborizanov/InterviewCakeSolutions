package interviewcake.solutions;

import org.junit.Assert;

class AppleStocksTest {

    @org.junit.jupiter.api.Test
    void testGetMaxProfit() {

        AppleStocks appleStocks = new AppleStocks();

        int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};
        Assert.assertEquals(6, appleStocks.getMaxProfit(stockPrices));

        stockPrices = new int[] {10, 9, 8, 7, 6, 5, 4, 3 };
        Assert.assertEquals(-1, appleStocks.getMaxProfit(stockPrices));

        stockPrices = new int[] {10, 10, 10, 10 };
        Assert.assertEquals(0, appleStocks.getMaxProfit(stockPrices));

    }
}