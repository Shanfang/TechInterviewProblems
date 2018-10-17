import java.util.*;

class CutMessage {
    static List<String> getMsgs(String str, int limit) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        int len = limit - 6; //(1/6) takes 5 chars + 1 char for space
        int start = 0, end = 0, i = 0;
        while (i <= str.length()) {
            if (i == str.length() || i < str.length() && str.charAt(i) == ' ') {
                if (i - start <= len) {
                    end = i;
                } else {
                    result.add(str.substring(start, end));
                    start = end + 1;
                }
            }
            i++;
        }
        result.add(str.substring(start));

        int size = result.size();
        for (int j = 0; j < size; j++) {
            String newStr = result.get(j) + " (" + (j + 1) + "/" + size + ")";
            result.set(j, newStr);
        }
        return result;
    }

    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //String str = "Hey Alice, your Uber is arriving now!";
        //String str = "a b";
        String str = input.nextLine().trim();
        for (String msg : getMsgs(str, 20)) {
            System.out.println(msg);
        }
    }
}
