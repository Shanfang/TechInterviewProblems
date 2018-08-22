class Solution {
    int[] array;
    Random random;
    public Solution(int[] nums) {
        array = nums;
        random = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                int x = random.nextInt(++count);
                index = x == 0 ? i : index;
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
