import java.util.*;

class PickFruits {
    static int pick(List<Integer> fruits) {
        if (fruits == null || fruits.size() == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int count = 0;
        int maxCount = 0;

        while (end < fruits.size()) {
            int fruit1 = fruits.get(end);
            map.put(fruit1, map.getOrDefault(fruit1, 0) + 1);
            if(map.get(fruit1) == 1) {
                count++;
            }
            end++;

            while(count > 2) {
                int fruit2 = fruits.get(start);
                map.put(fruit2, map.get(fruit2) - 1);
                if (map.get(fruit2) == 0) {
                    count--;
                }
                start++;
            }
            maxCount = Math.max(maxCount, end - start);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,1,1,1,2,2,3,1,2,3,3,2,2,5,9,6,9,6,6,6,6,6,6};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(pick(list));
    }
}
