// DP
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}

// recursion with memoization
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }

        Set<String> dict = new HashSet<>(wordDict);
        return helper(s, 0, dict, new Boolean[s.length()]);
    }

    private boolean helper(String str, int start, Set<String> dict, Boolean[] memo) {
        if (start == str.length()) {
            return true;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        for (int i = start + 1; i <= str.length(); i++) {
            if (dict.contains(str.substring(start, i)) && helper(str, i, dict, memo)) {
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }
}

// use BFS
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] processed = new boolean[s.length()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (!processed[start]) {
                for (int i = start + 1; i <= s.length(); i++) {
                    if (dict.contains(s.substring(start, i))) {
                        queue.offer(i);
                        if (i == s.length()) {
                            return true;
                        }
                    }
                }
                processed[start] = true;
            }
        }
        return false;
    }
}

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
