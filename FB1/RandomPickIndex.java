class Solution {
    int[] array;
    Random rand;
    public Solution(int[] nums) {
        array = nums;
        rand = new Random();
    }

    public int pick(int target) {
        int index = -1;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                int next  = rand.nextInt(++count);
                index = next == 0 ? i : index;
            }
        }
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
