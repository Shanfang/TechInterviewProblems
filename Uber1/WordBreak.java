// recursion, will cause TLE!!
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Set<String> dict = new HashSet<>(wordDict);
        return helper(s, 0, dict);
    }

    private boolean helper(String str, int start, Set<String> dict) {
        if (start == str.length()) {
            return true;
        }

        for (int i = start + 1; i <= str.length(); i++) {
            if (dict.contains(str.substring(start, i)) && helper(str, i, dict)) {
                return true;
            }
        }
        return false;
    }
}
