class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int size = list.size();
        if (x <= list.get(0)) {
            return list.subList(0, k);
        } else if (x >= list.get(size - 1)) {
            return list.subList(size - k, size);
        } else { // do binary search in the list
            int index = Collections.binarySearch(list, x);
            if (index < 0) {
                index = -index - 1;
            }
            int low = Math.max(index - k, 0);
            int high = Math.min(index + k - 1, size - 1);
            while (high - low + 1 > k) {
                if (list.get(high) - x < x - list.get(low)) {
                    low++;
                } else {
                    high--;
                }
            }
            return list.subList(low, high + 1);
        }

    }
}
