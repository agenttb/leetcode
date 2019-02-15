import org.junit.Assert;
import org.junit.Test;
import util.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayUtilTest {

    @Test
    public void testSwap() {
        int[] a = new int[] { 1, 2 ,3};
        ArrayUtils.swap(a, 0, 2);
        Assert.assertArrayEquals(new int[]{3, 2, 1}, a);
    }

    @Test
    public void testReverse() {
        int[] a = new int[] {1,2,3,4};
        ArrayUtils.reverse(a, 0, 3);
        Assert.assertArrayEquals(new int[] {4,3,2,1}, a);
    }

    @Test
    public void testNextPermutation() {
        int[] a = new int[]{1, 2, 3, 4};
        ArrayUtils.nextPermutation(a);
        Assert.assertArrayEquals(new int[] { 1, 2, 4, 3}, a);

    }

    @Test
    public void testNextPermutation1() {
        int[] a = new int[] {1,2,3};
        while (true) {
            ArrayUtils.nextPermutation(a);
            System.out.println(Arrays.toString(a));
            if (Arrays.equals(new int[] {3,2,1}, a)) {
                break;
            }
        }
    }
}
