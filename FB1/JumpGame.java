// bottom up DP
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] jump = new boolean[nums.length];
        jump[nums.length - 1] = true;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j <= Math.min(nums.length - 1, i + nums[i]); j++) {
                if (jump[j]) {
                    jump[i] = true;
                    break;
                }
            }
        }
        return jump[0];
    }
}

// greedy method, greedy is not bad, it works because we are guaranteed that if we can jump to end from last leftmost,
// then we can also jump to end from a position on the right side of leftmost
class Solution {
    public boolean canJump(int[] nums) {
        int lastLeftmost = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= lastLeftmost) {
                lastLeftmost = i;
            }
        }
        return lastLeftmost == 0;
    }
}
