class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            StringBuilder sb2 = new StringBuilder(strs[i]);
            sb.append(sb2.reverse().append(" "));
        }
        return sb.toString().trim();
    }
}
