class Solution {
    int[] arr;
    Random rand;
    public Solution(int[] nums) {
        this.arr = nums;
        rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return arr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (arr == null) {
            return null;
        }
        int[] array = arr.clone();
        for (int i = 1; i < array.length; i++) {
            int j = rand.nextInt(i + 1);
            swap(array, i, j);
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
