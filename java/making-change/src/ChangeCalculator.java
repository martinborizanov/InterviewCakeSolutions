import java.util.*;

public class ChangeCalculator {

    private static Integer[] findApplicableDenominations(int amount, Integer[] denominations){

        List<Integer> result = new ArrayList();

        for( int denom : denominations )
            if (denom <= amount)
                result.add(denom);

        return result.toArray(new Integer[0]);
    }

    private Map<Integer, Integer> memo = new HashMap();

    public int changePossibilities(int amount, Integer[] denominations ){

        if( amount == 0 || denominations.length == 0 )
            return 0;

        if( memo.containsKey(amount) ) {
            System.out.printf("Getting %s from memo", amount );
            return memo.get(amount);
        }

        int possibilities = 0;

        for( int denom : denominations ){

            int remainder = amount % denom;
            int result  = amount / denom;

            if(remainder != 0) {

                Integer[] applicableDenominations = findApplicableDenominations(remainder, denominations);
                if(applicableDenominations.length == 0) return 0;
                possibilities += changePossibilities(remainder, applicableDenominations);

            } else if( result != 0 && denom != 1 ){

                Integer[] applicableDenominations = findApplicableDenominations(result, denominations);
                if(applicableDenominations.length == 0) return 0;
                possibilities += changePossibilities(result, applicableDenominations);

            } else {
                possibilities++;
            }
        }


        return possibilities;
    }
}
