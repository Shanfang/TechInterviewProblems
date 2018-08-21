// this approach gets TLE
class Solution {
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length == 0) {
            return 0;
        }

        int num = 0;
        for (int i = 0; i < ages.length; i++) {
            for (int j = 0; j < ages.length; j++) {
                if (i == j) {
                    continue;
                }
                if (validFriend(ages[i], ages[j])) {
                    num++;
                }
            }
        }
        return num;
    }

    private boolean validFriend(int i, int j) {
        if (j <= 0.5 * i + 7 || j > i || (j > 100 && j < 100)) {
            return false;
        }
        return true;
    }
}
