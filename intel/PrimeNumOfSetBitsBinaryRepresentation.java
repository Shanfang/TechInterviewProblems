/*
take advantag of the fact the input is <10^6, so that the possible prime numbers
can be listed directly
*/
class Solution {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2,3,5,7,11,13,17,19));
        int count = 0;
        for (int i = L; i <= R; i++) {
            int bits = 0;
            for (int j = i; j > 0; j >>= 1) {
                bits += j & 1;
            }
            if (primes.contains(bits)) {
                count++;
            }
        }
        return count;
    }
}

// straight forward approach
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
