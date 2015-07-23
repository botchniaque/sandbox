package pl.bohocode.toptal;
// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution1 {
    public int solution(int X, int[] A) {
        if (A.length == 1) return -1;
        int[] markerArray = new int[A.length];
        for (int i = 0; i<A.length;i++) {
            markerArray[i] = A[i] == X? 1 : 0;
        }
        int matchesCount = 0;
        for (int i = 0; i<markerArray.length;i++) {
            matchesCount+=markerArray[i];
        }
        int currentMatches = 0;
        for (int i = 0; i<markerArray.length;i++) {
            currentMatches+=markerArray[i];
            int currentNotMatches = markerArray.length - i - (matchesCount - currentMatches);
            if (currentMatches == currentNotMatches) {
                return i;
            }
        }

        return -1;
    }
}