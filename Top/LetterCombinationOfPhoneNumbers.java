
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

        helper(digits, 0, map, new StringBuilder(), result);
        return result;
    }

    private void helper(String digits, int cur, Map<Character, String> map, StringBuilder sb, List<String> result) {
        if (cur == digits.length()) {
            result.add(sb.toString());
            return;
        }
        char c = digits.charAt(cur);
        for (char ch : map.get(c).toCharArray()) {
            sb.append(ch);
            helper(digits, cur + 1, map, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
