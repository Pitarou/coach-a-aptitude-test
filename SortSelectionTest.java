import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Test behaviour of class SortSelection.
 *
 * @author  Peter L. McArthur
 * @version 2014-07-10
 */
public class SortSelectionTest
{
    private SortSelection ss;
    int[] array1;
    int[] array3;
    int[] array4;
    int[] arrayRepeats;
    int[] arrayExampleGivenInSpecification;
    
    /**
     * Default constructor for test class SortSelectionTest
     */
    public SortSelectionTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void classSetUp()
    {
        this.ss = new SortSelection();
        this.array1 = new int[]{1};
        this.array3 = new int[]{1,2,3};
        this.array4 = new int[]{4, 3, 2, 1};
        this.arrayRepeats = new int[] {1,2,1,2,1,2,1};
        this.arrayExampleGivenInSpecification = new int[] {1, 4, 2, 3, 5, 8, 6, 9, 8, 0};
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void arrayWithOneElement() {
        assertEquals(this.ss.select(array1, 0), 1);
    }
    
    @Test
    public void arrayAlreadySorted() {
        assertEquals(this.ss.select(array3, 0), 3);
        assertEquals(this.ss.select(array3, 1), 2);
        assertEquals(this.ss.select(array3, 2), 1);

    }
    
    @Test
    public void arrayNotAlreadySorted() {
        assertEquals(this.ss.select(array4, 0), 4);
        assertEquals(this.ss.select(array4, 3), 1);
    }
    
    @Test
    public void arrayHasRepeatedElements() {
        assertEquals(this.ss.select(arrayRepeats, 2), 2);
        assertEquals(this.ss.select(arrayRepeats, 3), 1);
    }

    @Test
    public void checkThatOriginalArrayDoesNotChange() {
        this.ss.select(array4, 0);
        assertTrue(Arrays.equals(array4, new int[] {4, 3, 2, 1}));
        this.ss.select(array3, 0);
        assertTrue(Arrays.equals(array3, new int[] {1, 2, 3}));
    }
    
    @Test
    public void rankLessThanZero() {
        assertEquals(this.ss.select(array3, -1), 3);
    }
    
    @Test
    public void rankTooHigh() {
        assertEquals(this.ss.select(array3, 10), 1);
    }
    
    @Test
    public void exampleGivenInSpecification() {
        assertEquals(this.ss.select(arrayExampleGivenInSpecification, 2), 8);
    }
}
