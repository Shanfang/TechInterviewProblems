class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0.0;
        }
        if (n == 0) {
            return  1.0;
        }
        // for n = Integer.MIN_VALUE, simple sign flip cause overflow!!!
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return helper(x, N);

    }

    private double helper(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = helper(x, n / 2);
        if (n % 2 == 1) {
            return half * half * x;
        } else {
            return half * half;
        }
    }
}
