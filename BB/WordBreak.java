// memoization
class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Set<String> dict = new HashSet<>(wordDict);
        return helper(s, 0, s.length() - 1, dict);
    }

    private boolean helper(String str, int start, int end, Set<String> dict) {
        String str1 = str.substring(start, end + 1);
        if (memo.containsKey(str1)) {
            return memo.get(str1);
        }
        if (dict.contains(str1)) {
            return true;
        }
        for (int i = start; i <= end; i++) {
            String str2 = str.substring(start, i + 1);
            if (dict.contains(str2) && helper(str, i + 1, end, dict)) {
                memo.put(str1, true);
                return true;
            }
        }
        memo.put(str1, false);
        return false;
    }
}


// DP
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] isBreak = new boolean[s.length() + 1];
        isBreak[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isBreak[j] && dict.contains(s.substring(j, i))) {
                    isBreak[i] = true;
                    break;
                }
            }
        }
        return isBreak[s.length()];
    }
}

// TLE
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Set<String> dict = new HashSet<>(wordDict);
        return helper(s, 0, s.length() - 1, dict);
    }

    private boolean helper(String str, int start, int end, Set<String> dict) {
        if (dict.contains(str.substring(start, end + 1))) {
            return true;
        }
        boolean found = false;
        for (int i = start; i <= end; i++) {
            if (dict.contains(str.substring(start, i + 1))) {
                found = helper(str, i + 1, end, dict);
            }
            if (found) {
                break;
            }
        }
        return found;
    }
}
