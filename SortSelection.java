
/**
 * Implementation of IntegerSelection that uses Java's Array sort.
 * 
 * @author Peter L. McArthur
 * @version 2014-07-10
 */

import java.util.Arrays;

public class SortSelection implements IntegerSelection
{
 

    public int select(int[] array, int rank) {
        if (rank < 0) {
            rank = 0;
        } else if (rank >= array.length) {
            rank = array.length - 1;
        }
        int[] a = array.clone();
        Arrays.sort(a);
        return a[a.length - 1 - rank];
    }
}
