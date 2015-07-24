package pl.bohocode.toptal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * Created by szymek on 7/22/15.
 */
@RunWith(Parameterized.class)
public class Solution2Test {
    int[] input;
    int[] result;
    Solution2 solutionUT;

    public Solution2Test(int[] input, int[] result) {
        this.input = input;
        this.result = result;
    }

    @Before
    public void setUp() throws Exception {
        solutionUT = new Solution2();
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return asList(new Object[][]{
                        {new int[]{1, 0, 0, 1, 1}, new int[]{1, 1, 0, 1}},
                        {new int[]{1, 1, 0, 1, 0, 1, 1}, new int[]{1, 0, 0, 1, 1, 1}},
                }
        );
    }

    @Test
    public void testSolution() throws Exception {
        Assert.assertArrayEquals(result, solutionUT.solution(input));
    }

}