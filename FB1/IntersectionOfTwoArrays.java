/* use hashset to check existence
But if number are in a certain range,
just count number of appearance of each number from one array,
then loop another array, if it exists in the first array, add to result.
This would be constant space complexity.
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            if (!set1.contains(num)) {
                set1.add(num);
            }
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : set2) {
            list.add(num);
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (int num : list) {
            result[i++] = num;
        }
        return result;
    }
}
