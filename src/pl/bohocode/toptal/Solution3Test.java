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
public class Solution3Test {
    int[] input;
    int result;
    Solution3 solutionUT;

    public Solution3Test(int[] input, int result) {
        this.input = input;
        this.result = result;
    }

    @Before
    public void setUp() throws Exception {
        solutionUT = new Solution3();
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return asList(new Object[][]{
                        {new int[]{1, 2, 3, 4, 4, 3, 2}, 7},
                }
        );
    }

    @Test
    public void testSolution() throws Exception {
        Assert.assertEquals(result, solutionUT.solution(input));
    }
}