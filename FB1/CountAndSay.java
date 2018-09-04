class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String str = "1";
        while (n > 1) {
            int count = 0;
            char pre = '#';
            int index = 0;
            StringBuilder sb1 = new StringBuilder();
            while (index < str.length()) {
                if (pre == '#' || str.charAt(index) == str.charAt(index - 1)) {
                    pre = str.charAt(index);
                    count++;
                } else {
                    sb1.append(count).append(pre);
                    pre = str.charAt(index);
                    count = 1;
                }
                index++;
            }
            sb1.append(count).append(pre);
            str = sb1.toString();
            n--;
        }
        return str;
    }
}
