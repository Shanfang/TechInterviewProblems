class Solution {
    int[] sum;
    Random rand;
    public Solution(int[] w) {
        this.rand = new Random();
        for(int i=1; i<w.length; ++i) {
            w[i] += w[i - 1];
        }
        this.sum = w;
    }

    public int pickIndex() {
        int next = rand.nextInt(sum[sum.length - 1]) + 1;
        int start = 0, end = sum.length - 1;
        while (start < end) {
            int mid = start +(end - start) / 2;
            if (sum[mid] == next) {
                return mid;
            } else if (sum[mid] < next) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}

// this cause TLE as the list is too long
class Solution {
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();
    public Solution(int[] w) {
        for (int i = 0; i < w.length; i++) {
            int weight = w[i];
            while (weight > 0) {
                list.add(i);
                weight--;
            }
        }
    }

    public int pickIndex() {
        int next = rand.nextInt(list.size());
        return list.get(next);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
