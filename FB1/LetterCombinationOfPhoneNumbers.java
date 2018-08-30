class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(digits, 0, "", map, result);
        return result;
    }

    private void helper(String digits, int index, String cur, Map<Character, String> map,
                        List<String> result) {
        if (index == digits.length()) {
            result.add(cur);
            return;
        }
        for (char c : map.get(digits.charAt(index)).toCharArray()) {
            helper(digits, index + 1, cur + c, map, result);
        }
    }
}
