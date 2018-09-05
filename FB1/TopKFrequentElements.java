// use bucket sort
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // the size should be 1 more than the array length to allow frequency 0
        List<Integer>[] frequency = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (frequency[freq] == null) {
                frequency[freq] = new ArrayList<>();
            }
            frequency[freq].add(key);
        }

        for (int i = frequency.length - 1; i >= 0 && result.size() < k; i--) {
            if (frequency[i] == null) {
                continue;
            }
            result.addAll(frequency[i]);
        }
        return result;
    }
}
// use minHeap to find top k, this is a bit slow
class Solution {
    class Pair {
        int num;
        int freq;
        Pair(int val, int count) {
            num = val;
            freq = count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.freq - b.freq;
            }
        });
        for (int key : map.keySet()) {
            queue.offer(new Pair(key, map.get(key)));
            if(queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll().num);
        }
        Collections.reverse(result);
        return result;
    }
}
