/*
Basically the problems involves 2 dimensions, one is the numbers in the array
the other is the 32 bits for each of the number.
Since the order of processing which dimension does not matter(both dimension accumulate the different bits).
We can process the difference for a certain bit of all numbers. In this case, we can take advantage of some
maths to calculate the different bits pairwise, which is diffBits * (N - diffBits). This will reduce the time
complexity from O(N) to O(1) for computing different bits at a certain bit.
*/
class Solution {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int total = 0;
        for (int i = 0; i < 32; i++) {
            int ones = 0;
            for (int j = 0; j < nums.length; j++) {
                ones += nums[j] & 1;
                nums[j] >>= 1;
            }
            total += ones * (nums.length - ones);
        }
        return total;
    }
}
