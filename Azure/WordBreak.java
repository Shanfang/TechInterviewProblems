// optimize with memoization
class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Set<String> dict = new HashSet<>(wordDict);
        return helper(s, 0, s.length(), dict);
    }

    private boolean helper(String str, int start, int end, Set<String> dict) {
        String str1 = str.substring(start, end);
        if (memo.containsKey(str1)) {
            return memo.get(str1);
        }
        if (dict.contains(str1)) {
            return true;
        }

        for (int i = end - 1; i >= start; i--) {
            String str2 = str.substring(i, end);
            if (dict.contains(str2) && helper(str, start, i, dict)) {
                memo.put(str1, true);
                return true;
            }
        }
        memo.put(str1, false);
        return false;
    }
}


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
