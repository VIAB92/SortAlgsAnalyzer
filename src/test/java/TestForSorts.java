import static org.junit.Assert.*;

import Sorters.BubbleSort;
import org.junit.Before;
import org.junit.Test;
public class TestForSorts {
    int[] array;
    int[] expected;
    int[] result;
    @Before
    public void setUp()
    {
         array = new int[] {5,3,2,9,4,6};
        BubbleSort bSort = new BubbleSort(array.length,array);
        bSort.run();
        expected = new int[] {2,3,4,5,6,9};
        result = bSort.getArr();
    }
    @Test
    public void testSort()
    {
        boolean b = true;
        for (int i=0; i<array.length; i++)
            if (array[i]!=result[i]) b=false;
        assertTrue(b);

    }
}
