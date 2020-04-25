package interviewcake.solutions;

import java.util.Arrays;

public class AppleStocks {

    public int getMaxProfit( int[] stockPrices ){

        int buyPrice = stockPrices[0];
        int buyPriceTime = 0;

        for(int time = 0; time < stockPrices.length; time++ )
            if (buyPrice > stockPrices[time]) {
                buyPrice = stockPrices[time];
                buyPriceTime = time;
            }

        if( buyPriceTime == stockPrices.length-1 ) {
            buyPrice =  stockPrices[0];
            for (int time = 0; time < stockPrices.length - 1; time++)
                if (buyPrice > stockPrices[time]) {
                    buyPrice = stockPrices[time];
                }
        }
        int[] subsequentPrices = Arrays.copyOfRange(stockPrices,buyPriceTime, stockPrices.length);

        int sellPrice = 0;
        int lowestRemainingPrice = 0;

        for (int subsequentPrice : subsequentPrices) {
            if (sellPrice < subsequentPrice) sellPrice = subsequentPrice;
            if (lowestRemainingPrice > subsequentPrice) lowestRemainingPrice = subsequentPrice;
        }

        return ( sellPrice == 0 ) ? lowestRemainingPrice - buyPrice : sellPrice - buyPrice;
    }
}
