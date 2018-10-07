class Solution {
    Map<Integer, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return helper(s, dict, 0);
    }

    private List<String> helper(String str, Set<String> dict, int start) {

        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> result = new ArrayList<>();
        if (start == str.length()) {
            result.add("");
        }

        for (int i = start + 1; i <= str.length(); i++) {

            if (dict.contains(str.substring(start, i))) {
                List<String> list = helper(str, dict, i);
                // if the remaining part can not be broke into words, list.size() == 0, the following loop will not be execuated
                for (String s : list) {
                    String sentence = str.substring(start, i) + (s.equals("") ? "" : " ") + s;
                    result.add(sentence);
                }
            }
        }
        map.put(start, result);
        return result;
    }
}
