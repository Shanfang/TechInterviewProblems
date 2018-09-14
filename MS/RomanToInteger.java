// faster without hashmap

class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int sum = 0;
        char[] chars = s.toCharArray();
        int pre = convert(chars[0]);
        int cur = 0;
        sum = pre;

        for (int i = 1; i < s.length(); i++) {
            cur = convert(chars[i]);
            sum += cur;
            if (cur > pre) {
                sum -= 2 * pre;
            }
            pre = cur;
        }
        return sum;
    }

    private int convert(char c) {
        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return 0;
    }
}

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
