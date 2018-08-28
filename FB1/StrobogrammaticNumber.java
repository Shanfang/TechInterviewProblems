class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        int i = 0, j = num.length() - 1;
        while (i < j) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(j);
            if (map.get(c1) == null || map.get(c1) != c2) {
                return false;
            }
            i++;
            j--;
        }
        if (i == j) {
            char c = num.charAt(i);
            return c == '0' || c == '1' || c == '8';
        }
        return true;
    }
}
