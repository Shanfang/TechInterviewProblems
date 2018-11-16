class Solution {
    public double myPow(double x, int n) {
        if (x == 0 || n == 0){
            return 1.0;
        }
        long m = n;
        if (m < 0) {
            x = 1 / x;
            m = -m;
        }

        double result = 1;
        double curProd = x;
        while (m > 0) {
            if (m % 2 == 1) {
                result = curProd * result;
            }
            curProd = curProd * curProd;
            m /= 2;
        }
        return result;
    }
}
