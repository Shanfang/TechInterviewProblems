class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0) {
            return x;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return binarySearchPow(x, n);
    }

    private double binarySearchPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            double half = binarySearchPow(x, n / 2);
            return half * half;
        } else {
            double half = binarySearchPow(x, n / 2);
            return half * half * x;
        }
    }
}
