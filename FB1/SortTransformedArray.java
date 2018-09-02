class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int[] result = new int[nums.length];
        int index = a >= 0 ? nums.length - 1 : 0;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int num1 = compute(nums[i], a, b, c);
            int num2 = compute(nums[j], a, b, c);
            if (a >= 0) {
                if (num1 > num2) {
                    result[index--] = num1;
                    i++;
                } else {
                    result[index--] = num2;
                    j--;
                }
            } else {
                if (num1 < num2) {
                    result[index++] = num1;
                    i++;
                } else {
                    result[index++] = num2;
                    j--;
                }
            }
        }
        return result;
    }

    private int compute(int num, int a, int b, int c) {
        return a * num * num + b * num + c;
    }
}
