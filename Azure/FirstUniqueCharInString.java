// two passes
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        Arrays.fill(count, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count[c - 'a'] == -1) {
                count[c - 'a'] = i;
            } else {
                count[c - 'a'] = -2; // mark it as already visited
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] >= 0) {
                return i;
            }
        }
        return -1;
    }
}

// one pass, but time complexity is bad
class Solution {
    public int firstUniqChar(String s) {
        int index = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int first = s.indexOf(c);
            if (first < 0) {
                continue;
            }
            int last = s.lastIndexOf(c);
            if (first == last) {
                index = i;
            }
        }
        return index;
    }
}
