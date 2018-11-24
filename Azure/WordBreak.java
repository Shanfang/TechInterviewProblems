// this will cause TLE
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        return helper(s, s.length(), wordDict);
    }

    private boolean helper(String s, int end, List<String> wordDict) {
        if (end == 0) {
            return true;
        }
        boolean result = false;
        for (int i = end - 1; i >= 0; i--) {
            if (wordDict.contains(s.substring(i, end)) && helper(s, i, wordDict)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
