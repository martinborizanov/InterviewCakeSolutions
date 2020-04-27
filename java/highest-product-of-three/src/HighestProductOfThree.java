import java.util.Arrays;

public class HighestProductOfThree {
    int calcHighestProduct( int[] arrayOfInts ){

        Arrays.sort(arrayOfInts);

        int firstH  = arrayOfInts[arrayOfInts.length - 1];
        int secondH = arrayOfInts[arrayOfInts.length - 2];
        int thirdH  = arrayOfInts[arrayOfInts.length - 3];

        int firstL = arrayOfInts[0];
        int secondL = arrayOfInts[1];

        boolean useNegatives = firstL * secondL > firstH * secondH;

        return useNegatives ? firstL*secondL*firstH : firstH*secondH*thirdH;

    }
}
