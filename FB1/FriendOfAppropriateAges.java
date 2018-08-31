class Solution {
    public int numFriendRequests(int[] ages) {
        int len = ages.length;
        int[] sameAges = new int[121];
        int[] underAges = new int[121];

        for (int age : ages) {
            sameAges[age]++;
        }

        // inclusive age
        for (int i = 1; i < 121; i++) {
            underAges[i] += underAges[i - 1] + sameAges[i];
        }

        int num = 0;
        for (int i = 15; i < 121; i++) {
            num += (underAges[i] - underAges[i / 2 + 7]) * sameAges[i] - sameAges[i];
        }
        return num;
    }
}
