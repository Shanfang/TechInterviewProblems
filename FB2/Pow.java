// 1. use long type when flip the sign
//2. in the helper method, store the result when cut n by half, so it can be used directly
// to calculate result for different scenarios, this is similar to memoization in DP
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

// recursive approach
class Solution {
    public double myPow(double x, int n) {
        if (x == 0 || n == 0) {
            return 1.0;
        }
        long N = n;
        if (N < 0) {
            x = 1/ x;
            N = -N;
        }
        double result = 1;
        double curProd = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                result = result * curProd;
            }
            curProd = curProd * curProd;
        }
        return result;
    }
}
