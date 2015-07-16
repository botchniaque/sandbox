package pl.bohocode.codility;

import java.util.Arrays;

/**
 *
 * http://stackoverflow.com/questions/24111349/codility-challenge-test-case-ok-evaluation-report-wrong-answer
 *
 * A non-empty zero-indexed array A consisting of N integers is given.
 * A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.
 * The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q]. The maximum
 * sum is the maximum sum of any slice of A. For example, consider array A
 * such that: A[0] = 3 A[1] = 2 A[2] = -6 A[3] = 3 A[4] = 1 For example (0, 1) is a slice of A that
 * has sum A[0] + A[1] = 5. This is the maximum sum of A. You can perform a single swap operation in array A.
 * This operation takes two indices I and J, such that 0 ≤ I ≤ J < N, and exchanges the values of A[I] and A[J].
 * To goal is to find the maximum sum you can achieve after performing a single swap. For example,
 * after swapping elements 2 and 4, you will get the following array A: A[0] = 3 A[1] = 2 A[2] = 1 A[3] = 3 A[4] = -6
 * After that, (0, 3) is a slice of A that has the sum A[0] + A[1] + A[2] + A[3] = 9.
 * This is the maximum sum of A after a single swap.
 *
 * Write a function: class Solution { public int solution(int[] A); } that,
 * given a non-empty zero-indexed array A of N integers, returns the maximum sum of any slice of A after a single swap operation.
 * For example, given: A[0] = 3 A[1] = 2 A[2] = -6 A[3] = 3 A[4] = 1 the function should return 9, as explained above.
 *
 * @author <a href="szymon.bochniak@profitbricks.com">Szymon Bochniak</a>
 */
public class Solution {
    public int solution(int[] A) {
        if (A.length == 1) return A[0];
        if (A.length == 2) {
            return A[0] + A[1];
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i=0;i < A.length;i++) {
            for (int j=i+1; j < A.length; j++) {
                int[] B = swapElements(A, i, j);
                int maxSumPerTrnasposure = findMaxSum(B);
                maxSum = Math.max(maxSum, maxSumPerTrnasposure);
            }
        }
        return maxSum;
    }

    private int findMaxSum(int[] B) {
        int maxSum = Integer.MIN_VALUE;
        for (int i=0;i < B.length;i++) {
            int maxSumPerIndex = B[i];
            int currentSum = B[i];
            for (int j = i + 1; j < B.length; j++) {
                currentSum += B[j];
                maxSumPerIndex = Math.max(maxSumPerIndex, currentSum);
            }
            maxSum = Math.max(maxSum, maxSumPerIndex);
        }
        return maxSum;
    }

    private int[] swapElements(final int[] A, int i, int j) {
        int[] copy = Arrays.copyOf(A, A.length);
        int temp = copy[i];
        copy[i] = copy[j];
        copy[j] = temp;
        return copy;
    }
}
