class Solution {
    public int countPrimeSetBits(int L, int R) {
        if (R - L == 0) {
            return 0;
        }
        int count = 0;
        for (int i = L; i <= R; i++) {
            int bitCounts = Integer.bitCount(i); // use the built in method
            if (isPrime(bitCounts)) {
                count++;
            }
            // if (isPrime(countBit(i))) {
            //     count++;
            // }
        }
        return count;
    }

    private int countBit(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

    private boolean isPrime(int num) {
        if (num == 1 || num == 0) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
