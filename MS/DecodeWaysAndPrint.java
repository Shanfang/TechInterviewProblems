import java.util.*;

class DecodeWaysAndPrint {
    static Set<String> convert(String s) {
        Set<String> result = new HashSet<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        helper(s, 0, result, new StringBuilder());
        return result;
    }

    private static void helper(String s, int index, Set<String> result, StringBuilder sb) {
        if (index == s.length()) {
            result.add(sb.toString());
            return;
        }
        int digit = s.charAt(index) - '0';
        if (digit > 0 && digit <= 9) {
            sb.append((char)('A' + (digit - 1)));
            helper(s, index + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (index > 0) {
            int digits = Integer.valueOf(s.substring(index - 1, index + 1));
            if (digits >= 10 && digits <= 26) {
                char pre = sb.charAt(sb.length() - 1);
                if (pre - 'A' > 0 && pre - 'A' <= 9) {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append((char)('A' + (digits - 1)));
                    helper(s, index + 1, result, sb);
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(pre);
                } else {
                    char prePre = (char)('A' + ((pre - 'A') / 10 - 1));
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(prePre);
                    sb.append((char)('A' + (digits - 1)));
                    helper(s, index + 1, result, sb);
                    sb.deleteCharAt(sb.length() -  2);
                    sb.append(pre);
                }
            }
        }
    }
    public static void main(String[] args) {
        String s = "226";
        for (String str : convert(s)) {
            System.out.println(str);
        }
    }
}
