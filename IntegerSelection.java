
/**
 * Interface for a method selecting the nth highest integer in an array.
 * 
 * @author Peter L. McArthur
 * @version 2014-07-10
 */
public interface IntegerSelection
{
    /**
     * Return the nth highest integer in the given array.
     * 
     * @param array   a non-empty array of ints
     * @param rank   0 for the highest integer, array.length - 1 for the lowest. Values outside the range [0..array.length - 1] are pulled into the valid range.
     * @return  the integer of the chosen rank in the array
     */
    public int select(int[] array, int rank); 
}
