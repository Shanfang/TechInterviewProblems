class Solution {
    public int countPrimes(int n) {
        boolean[] nonPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!nonPrime[i]) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    nonPrime[i * j] = true;
                }
            }
        }
        return count;
    }
}
