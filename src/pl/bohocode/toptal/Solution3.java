package pl.bohocode.toptal;// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution3 {
    public int solution(int[] A) {
        int[] west = {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] north = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] south = {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] east = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};

        int x = 0;
        int y = 0;

        // write your code in Java SE 8
        for (int i = 0; i < A.length; i++) {
            if (i%4 == 0) {//north
                y+=A[i];
                west[0] = x;
                west[1] = Math.min(west[1], y);
                west[2] = Math.max(west[2], y);
                if (north[0] <= y && north[1] <= x && north[2] >= x) return i;
                if (south[0] <= y && south[1] <= x && south[2] >= x) return i;
            }
            if (i%4 == 1) {//east
                x+=A[i];
                north[0] = y;
                north[1] = Math.min(north[1], x);
                north[2] = Math.max(north[2], x);
                if (east[0] <= x && east[1] <= y && east[2] >= y) return i;
                if (west[0] <= x && west[1] <= y && west[2] >= y) return i;

            }
            if (i%4 == 2) {//south
                y-=A[i];
                east[0] = x;
                east[1] = Math.min(east[1], y);
                east[2] = Math.max(east[2], y);
                if (north[0] >= y && north[1] <= x && north[2] >= x) return i;
                if (south[0] >= y && south[1] <= x && south[2] >= x) return i;

            }
            if (i%4 == 3) {//west
                x-=A[i];
                south[0] = y;
                south[1] = Math.min(south[1], y);
                south[2] = Math.max(south[2], y);
                if (east[0] >= x && east[1] <= x && east[2] >= x) return i;
                if (west[0] >= x && west[1] <= x && west[2] >= x) return i;

            }

        }
        return 0;
    }
}