class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        int pre = Integer.MIN_VALUE;
        int i = s.length() - 1;
        while (i >= 0) {
            int cur = map.get(s.charAt(i));
            sum += cur;
            if (cur < pre) {
                sum -= 2 * cur;
            }
            pre = cur;
            i--;
        }
        return sum;
    }
}
