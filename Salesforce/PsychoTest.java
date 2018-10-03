import java.util.*;

class PsychoTest {
    static int[] countCandidate (int[] scores, int[] lower, int[] upper) {
        Arrays.sort(scores);
        int len = lower.length;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            int start = searchStart(scores, lower[i]);
            int end = searchEnd(scores, upper[i]);
            result[i] = end - start + 1;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] scores = {1,2,3,4,5,6,7,8,9,10};
        int[] lower = {0,3,5};
        int[] upper = {10,12,5};
        int[] result = countCandidate(scores, lower, upper);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int searchStart(int[] scores, int target) {
        int start = 0, end = scores.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (scores[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (scores[start] >= target) {
            return start;
        } else if (scores[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }

    private static int searchEnd(int[] scores, int target) {
        int start = 0, end = scores.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (scores[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (scores[end] <= target) {
            return end;
        } else if (scores[start] <= target) {
            return start;
        } else {
            return start - 1;
        }
    }
}
