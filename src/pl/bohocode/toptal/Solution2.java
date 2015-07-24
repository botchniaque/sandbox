package pl.bohocode.toptal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szymek on 7/23/15.
 */
public class Solution2 {
    public int[] solution(int[] A) {
        int value = 0;
        for (int i = 0; i < A.length; i++) {
            value += A[i] * Math.pow(-2, i);
        }
        int negValue = -value;
        int remeinder = 0;
        List<Integer> resultList = new ArrayList<>();

        while (negValue != 0) {
            remeinder = negValue % -2;
            negValue = negValue / -2;
            if (remeinder < 0) {
                remeinder+=2;
                negValue +=1;
            }
            resultList.add(remeinder);
        }

        return toPrimitiveArray(resultList);
    }

    private int[] toPrimitiveArray(List<Integer> resultList) {
        int[] result = new int[resultList.size()];
        for (int i = 0; i< result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
