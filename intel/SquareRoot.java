// consice binary search
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int start = 0, end = x;
        while (true) {
            int mid = start + (end - start) / 2;
            if (mid > x / mid) {
                end = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }
        }
    }
}
// binary search template
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
