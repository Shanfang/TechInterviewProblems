import java.util.*;

class RearrangeWords {
    public static String rearrange(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String[] strs = str.split(" ");
        Map<Integer, List<String>> buckets = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            buckets.put(i, new ArrayList<String>());
        }
        for (int i = 0; i < strs.length; i++) {
            int len = strs[i].length();
            String str1 = strs[i].toLowerCase();
            if (i != strs.length - 1) {
                buckets.get(len).add(str1);
            } else {
                buckets.get(len - 1).add(str1.substring(0, len - 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (buckets.get(i).size() > 0) {
                for (String str2 : buckets.get(i)) {
                    sb.append(" ").append(str2);
                }
            }
        }

        String result = sb.append(".").toString();
        result = result.trim();
        result = result.substring(0, 1).toUpperCase() + result.substring(1);
        return result;
    }

    public static void main(String[] args) {
        String str = "I love to code.";
        System.out.println(rearrange(str));
    }

}
