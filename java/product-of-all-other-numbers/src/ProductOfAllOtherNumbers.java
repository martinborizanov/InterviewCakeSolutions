public class ProductOfAllOtherNumbers {

    public int[] getProductsOfAllIntsExceptAtIndex( int[] integers ){

        if( integers.length == 0) throw new IllegalArgumentException("Can't calc with 0 integers!");

        int[] RV = new int[integers.length];

        int soFar = 1;
        for(int i = 0; i < integers.length; i++){
            RV[i] = soFar;
            soFar *= integers[i];
        }

        soFar = 1;
        for( int i = integers.length - 1; i >= 0; i-- ){
            RV[i] *= soFar;
            soFar *= integers[i];
        }

        return RV;
    }
}
