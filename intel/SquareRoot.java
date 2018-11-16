class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long num = (long)x;
        long start = 0, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == num) {
                return (int)mid;
            } else if (mid * mid > num) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end * end <= num) {
            return (int)end;
        }
        return (int)start;
    }
}
