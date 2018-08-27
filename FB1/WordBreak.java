/*
DP with memoization
1. line18, when a string already exists in memo, return whether is can be break into words in the dict
2. line28, if we can not break a string after looping through all possible breaking point, DO NOT forget
to mark it in memo that this string can not be break int valid words, otherwise this memo does not do its work!!
*/
class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }

        Set<String> set = new HashSet<>(wordDict);
        return wordBreak(s, set);
    }

    private boolean wordBreak(String s, Set<String> set) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (set.contains(s)) {
            return true;
        }
        for (int i = 1; i < s.length(); i++) {
            String leftStr = s.substring(0, i);
            String rightStr = s.substring(i);
            if (set.contains(rightStr) && wordBreak(leftStr, set)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
