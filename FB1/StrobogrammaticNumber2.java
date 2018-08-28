class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int len, int n) {
        if (len == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (len == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
        List<String> result = new ArrayList<>();
        List<String> list = helper(len - 2, n);
        for (String str : list) {
            if (len != n) {
                result.add("0" + str + "0");
            }
            result.add("1" + str + "1");
            result.add("6" + str + "9");
            result.add("8" + str + "8");
            result.add("9" + str + "6");
        }
        return result;
    }
}
/*

// this is my initial solution, it is clunky and the logic is not clear enough
// basically, this problem is like find paths in binary tree. First find paths from left and right child,
then attach root node's value. But here the root values can be many 4/5 pairs(he outmost layer 4 pairs)
class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            result.add("");
            return result;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        if (n % 2 == 0) {
            helper(0, n, "", map, result);
        } else {
            for (Character c : map.keySet()) {
                helper(1, n, String.valueOf(c), map, result);
            }
        }
        return result;
    }

    private void helper(int len, int n, String cur, Map<Character, Character> map, List<String> result) {
        if (len == n && cur.charAt(0) != '0') {
            result.add(cur);
            return;
        }
        for (Character c1 : map.keySet()) {
            char c2 = map.get(c1);
            helper(len + 2, n, c1 + cur + c2, map, result);
        }
    }
}*/
