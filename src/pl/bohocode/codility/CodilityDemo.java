package pl.bohocode.codility;// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class CodilityDemo {
    public int solution(int[] A) {
        // write your code in Java SE 8
        long leftSum = 0;
        long rightSum = 0;
        long totalSum = 0;
        for (int i = 0; i<A.length; i++) {
            totalSum += A[i];
        }

        for (int i = 0; i < A.length; i++) {
            rightSum = totalSum - A[i] - leftSum;
            if (leftSum == rightSum) {
                return i;
            }
            leftSum +=A[i];
        }
        return -1;
    }
}