import java.util.*;

class CutMessage {
    static List<String> getMsgs(String str, int limit) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        int len = limit - 5; //(1/6) takes 5 chars
        int start = 0, end = 0, i = 0;
        while (i <= str.length()) {
            if (i == str.length() || i < str.length() && str.charAt(i) == ' ') {
                if (i - start < len) {
                    end = i;
                } else {
                    result.add(str.substring(start, end));
                    start = end + 1;
                }
            }
            i++;
        }
        result.add(str.substring(start, end));

        int size = result.size();
        for (int j = 0; j < size; j++) {
            String newStr = result.get(j) + "(" + (j + 1) + "/" + size + ")";
            result.set(j, newStr);
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "Hey Alice, your Uber is arriving now!";
        for (String msg : getMsgs(str, 20)) {
            System.out.println(msg);
        }
    }
}
