import java.lang.reflect.Array;
import java.util.*;

public class TempTracker {

    private List<Integer> temperatures = new ArrayList<Integer>();
    private Map<Integer, Integer> occurences = new HashMap<Integer, Integer>();

    void insert( int temperature ){

        // Add to the collection
        temperatures.add(temperature);

        // Add or increment occurrences
        if( occurences.containsKey(temperature) ) occurences.merge(temperature,1, Integer::sum);
        else occurences.put(temperature, 1);

        // Sort
        Collections.sort(temperatures);
    }

    public int getMax() {
        return temperatures.get( temperatures.size() - 1 );
    };

    public int getMin() {
        return temperatures.get(0);
    }

    public double getMean() {

        double sum = 0;

        for( int temp : temperatures ) sum += temp;

        double mean = sum / temperatures.size();

        return mean;

    }

    public int getMode() {

        int maxOccurences = 0;
        int mode = -1;

        for( Integer value : occurences.values() ) maxOccurences = Math.max( value, maxOccurences );


        for( Map.Entry<Integer, Integer> entry : occurences.entrySet() ){
            if( entry.getValue() == maxOccurences ) return( entry.getKey() );
        }

        return mode;
    }


}
