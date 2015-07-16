package pl.bohocode.codility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * Comment on me!
 *
 * @author <a href="szymon.bochniak@profitbricks.com">Szymon Bochniak</a>
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    int[] input;
    int result;
    Solution solutionUT;

    public SolutionTest(int[] input, int result) {
        this.input = input;
        this.result = result;
    }

    @Before
    public void setUp() throws Exception {
        solutionUT = new Solution();
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return asList(new Object[][]{
                        {new int[]{2}, 2},
                        {new int[]{2, 3}, 5},
                        {new int[]{3, 9, -6, 7, -3, 9, -6, -10}, 28},
                        {new int[]{2, 45, 1, 2, 3, 4, 5, 6}, 68},
                        {new int[]{2, -45, 1, 2, 3, 4, 5, 6}, 23},
                        {new int[]{-1, -2, -9, -8, -1, 0, -3}, 0},
                }
        );
    }

    @Test
    public void testSolution() throws Exception {
        Assert.assertEquals("normal order", result, solutionUT.solution(input));
        Assert.assertEquals("reversed order", result, solutionUT.solution(reverse(input)));
    }

    private int[] reverse(int[] arr) {
        int[] reversed = new int[arr.length];
        int index = arr.length - 1;
        for (int i : arr) {
            reversed[index] = i;
            index--;
        }
        return reversed;
    }

}