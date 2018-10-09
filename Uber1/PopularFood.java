import java.util.*;

class PopularFood {
    static List<List<String>> findFood(List<String[]> list, int k) {
        List<List<String>> result = new ArrayList<>();
        List<HashMap<String, Integer>> maps = new ArrayList<>();
        List<TreeMap<Integer, List<String>>> freqMaps = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            maps.add(new HashMap<>());
            freqMaps.add(new TreeMap<>());
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < list.size(); i++) {
            String[] arr = list.get(i);
            String food = arr[0];
            int hour = Integer.valueOf(arr[1]);

            HashMap<String, Integer> map = maps.get(hour);
            map.put(food, map.getOrDefault(food, 0) + 1);
        }

        for (int i = 0; i < 24; i++) {
            TreeMap<Integer, List<String>> freqMap = freqMaps.get(i);
            HashMap<String, Integer> map = maps.get(i);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int freq = entry.getValue();
                if (!freqMap.containsKey(freq)) {
                    freqMap.put(freq, new ArrayList<>());
                }
                freqMap.get(freq).add(entry.getKey());
            }
            for (int j = 0; j < k; j++) {
                if (freqMap.isEmpty()) {
                    break;
                }
                Map.Entry<Integer, List<String>> freqEntry = freqMap.pollLastEntry();
                result.get(i).addAll(freqEntry.getValue());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] arr = {{"Apple", "1"},{"Apple", "1"},{"Orange", "1"},{"Orange", "2"},{"Orange", "3"}};
        int k = 5;
        List<String[]> orders = Arrays.asList(arr);
        List<List<String>> result = findFood(orders, k);

        for (int i = 0; i < 24; i++) {
            for (String food : result.get(i)) {
                System.out.println("During Hour " + i + ": Top " + k + " popular food is " + food);
            }
        }
    }
}
