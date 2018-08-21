class Solution {
    public int maximumSwap(int num) {
        int[] buckets = new int[10];
        char[] chars = Integer.toString(num).toCharArray();

        for (int i = 0; i < chars.length; i++) {
            buckets[chars[i] - '0'] = i;
        }

        for (int i = 0; i < chars.length; i++) {
            for (int j = 9; j > chars[i] - '0'; j--) {
                if (buckets[j] > i) { // find an digit that comes after chars[i]
                    char temp = chars[i];
                    chars[i] = chars[buckets[j]];
                    chars[buckets[j]] = temp;
                    return Integer.parseInt(String.valueOf(chars));
                }
            }
        }
        return num;
    }
}
