class Solution {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int dist = 0;
        while (num > 0) {
            dist += num & 1;
            num >>= 1;
        }
        return dist;
    }
}
