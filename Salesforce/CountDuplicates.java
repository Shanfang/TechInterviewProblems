import java.util.*;

class CountDuplicates {
    static int countDup(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,3,4,9,2,4,5,3,8,8,4,3};
        System.out.println(countDup(arr));
    }
}
