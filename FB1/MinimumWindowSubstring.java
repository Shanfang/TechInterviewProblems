class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        String result  = "";
        int[] sArray = new int[256];
        int[] tArray = new int[256];
        for (char c : t.toCharArray()) {
            tArray[c]++;
        }

        int left = findNext(s, tArray, 0);
        if (left == s.length()) {
            return result;
        }

        int right = left;
        int tLen = t.length();
        int found = 0;
        while (right < s.length()) {
            int rCharInt = (int)s.charAt(right);
            if (sArray[rCharInt] < tArray[rCharInt]) {
                found++;
            }
            sArray[rCharInt]++;

            // shrink substring by moving left rightward
            while (left < s.length() && found == tLen) {
                if (result.isEmpty() || result.length() > right - left + 1) {
                    result = s.substring(left, right + 1);
                }
                int lCharInt = (int)s.charAt(left);
                if (sArray[lCharInt] <= tArray[lCharInt]) {
                    found--;
                }
                sArray[lCharInt]--;

                left = findNext(s, tArray, left + 1);
            }
            right = findNext(s, tArray, right + 1);
        }

        return result;
    }

    private int findNext(String s, int[] array, int start) {
        while (start < s.length()) {
            if (array[(int)s.charAt(start)] > 0) {
                return start;
            }
            start++;
        }
        return s.length();
    }
}
