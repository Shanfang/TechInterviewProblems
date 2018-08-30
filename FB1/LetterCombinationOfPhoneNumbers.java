// recursive approach
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

// recursive approach
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
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

        LinkedList<String> queue = new LinkedList<>();
        queue.offer("");
        int layer = 0; // in fact layer is not needed, use str.length() to indicate the index in digits
        while (!queue.isEmpty()) {
            if (queue.peek().length() == digits.length()) {
                break;
            }
            layer++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                for (char c : map.get(digits.charAt(layer - 1)).toCharArray()) {
                    queue.offer(str + c);
                }
            }
        }
        return queue;
    }
}
