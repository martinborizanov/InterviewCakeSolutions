import java.util.Arrays;

public class HighestProductOfThree {
    int calcHighestProduct( int[] arrayOfInts ){

        int highestProductOf3 = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];
        int highestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
        int lowestProductOf2  = arrayOfInts[0] * arrayOfInts[1];

        int highest = arrayOfInts[0];
        int lowest  = arrayOfInts[0];

        for(int current : arrayOfInts){

            highestProductOf3 = Math.max( Math.max( highestProductOf3, highestProductOf2 * current ), lowestProductOf2 * current);

            lowestProductOf2 = Math.min( Math.min( lowestProductOf2, current * lowest ), current * highest );
            highestProductOf2 = Math.max( Math.max( highestProductOf2, current * lowest ), current * highest );

            lowest = Math.min( lowest, current );
            highest = Math.max( highest, current );
        }

        return highestProductOf3;
    }
}

