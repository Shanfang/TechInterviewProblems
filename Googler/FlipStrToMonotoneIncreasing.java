class Solution {
    public int minFlipsMonoIncr(String S) {
        char[] chars = S.toCharArray();
        int len = S.length();

        int[] changes = new int[len + 1];
        changes[0] = 0;

        for (int i = 1; i <= len; i++) {
            if (chars[i - 1] == '1') {
                changes[i] = changes[i - 1] + 1;
            } else {
                changes[i] = changes[i - 1];
            }
        }

        int min = len;
        for (int i = 0; i <= len; i++) {
            int zeroToOnes = (len - i) - (changes[len] - changes[i]);
            min = Math.min(min, zeroToOnes + changes[i]);
        }
        return min;
    }
}
