import java.util.*;
import java.math.*;

class MinAbsoluteDifference {
    static int minAbs(int[] arr) {
        if (arr == null || arr.length < 2){
            return Integer.MAX_VALUE;
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, Math.abs(arr[i]-arr[i - 1]));
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 2,4};
        System.out.println(minAbs(arr));
    }
}
