class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int len = nums.length;
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (count1 == 0 && candidate2 != num) {
                candidate1 = num;
            } else if (count2 == 0) {
                candidate2 = num;
            }
            if (num == candidate1) {
                count1++;
            }  else if (num == candidate2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        if (count1 > len / 3) {
            result.add(candidate1);
        }
        if(count2 > len / 3) {
            result.add(candidate2);
        }
        return result;
    }
}
