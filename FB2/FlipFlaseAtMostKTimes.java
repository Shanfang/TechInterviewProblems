import java.util.*;
public class FlipFlaseAtMostKTimes {
    public int lengthOfMaxStringFlipFalse(List<Boolean> list, int k) {
        if (list == null || list.size() == 0) {
            return 0;
        }

        int maxLen = 0;
        int start = 0, end  = 0;
        int counter = 0;
        int head = 0, tail = 0;
        while (end < list.size()) {
            if (list.get(end) == false) {
                counter++;
            }
            end++;
            while (counter > k) {
                if (!list.get(start)) {
                    counter--;
                }
                start++;
            }
            if (end - start > maxLen) {
                maxLen = Math.max(maxLen, end - start);
                head = start;
                tail = end;
            }
        }
        System.out.println("head index " + head + " tail index " + tail);
        return maxLen;
    }

    public static void main(String[] args) {
        List<Boolean> list = new ArrayList<Boolean>(Arrays.asList(new Boolean[11]));
        Collections.fill(list, Boolean.FALSE);
        list.set(4, true);
        list.set(5, true);
        list.set(6, true);
        list.set(8, true);
        list.set(10, true);
        FlipFlaseAtMostKTimes flip = new FlipFlaseAtMostKTimes();
        int max = flip.lengthOfMaxStringFlipFalse(list, 3);
        System.out.println(max);
    }
}
