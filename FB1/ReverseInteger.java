// in math, mod always returns non-negative number
// but in java, it returns remainder, which could be negative
// so in the following solution we take advange of this trick,
// it would not work if mod always return >=0 numbers
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
