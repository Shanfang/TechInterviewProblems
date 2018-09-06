class Solution {
    public int reverse(int x) {
        long num = 0;
        while (x != 0) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        int result = (int)num;
        if (result != num) {
            return 0;
        }
        return result;
    }
}
