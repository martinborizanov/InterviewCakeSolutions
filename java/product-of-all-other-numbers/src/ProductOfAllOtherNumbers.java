public class ProductOfAllOtherNumbers {

    public int[] getProductsOfAllIntsExceptAtIndex( int[] integers ){

        if( integers.length == 0) throw new IllegalArgumentException("Can't calc with 0 integers!");

        int[] RV = new int[integers.length];

        for(int i = 0; i < integers.length; i++){
            int result = 1;

            for(int j = 0; j < integers.length; j++){
                if(j == i) continue;
                result *= integers[j];
            }

            RV[i] = result;
        }

        return RV;
    }
}
