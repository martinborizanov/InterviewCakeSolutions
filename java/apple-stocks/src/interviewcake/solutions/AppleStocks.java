package interviewcake.solutions;

import java.util.Arrays;

public class AppleStocks {

    public int getMaxProfit( int[] stockPrices ) throws IllegalArgumentException {

        if( stockPrices.length <= 2) throw new IllegalArgumentException("Can't calculate with less than 2 prices");

        int minPrice = stockPrices[0];
        int maxProfit = stockPrices[1] - stockPrices[0];

        for( int i = 1; i < stockPrices.length; i++ ){
            maxProfit = Math.max( maxProfit, stockPrices[i] - minPrice );
            minPrice = Math.min( stockPrices[i], minPrice);
        }

        return maxProfit;
    }
}
