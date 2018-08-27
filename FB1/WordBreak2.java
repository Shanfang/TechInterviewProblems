class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        Set<String> dict = new HashSet<>(wordDict);
        return helper(s, map, dict);
    }

    private List<String> helper(String s, Map<String, List<String>> map, Set<String> dict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> strings = new ArrayList<>();

        if (dict.contains(s)) {
            strings.add(s); // do not return here, need to find if S can be further divided!!!
        }
        for (int i = 1; i <= s.length(); i++) {
            String leftStr = s.substring(0 , i);
            String rightStr = s.substring(i);
            if (!dict.contains(rightStr)) {
                continue;
            }
            List<String> list = helper(leftStr, map, dict);
            for (String sentence : list) {
                strings.add(sentence + " " + rightStr);
            }
        }
        map.put(s, strings);
        return strings;
    }
}
