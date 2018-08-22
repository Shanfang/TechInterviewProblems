class Solution {
    public int numFriendRequests(int[] ages) {
        // we can convert the friending conditin into a concise one
        // A can friend B if B's age is in range (A/2+7, A]

        int[] withSameAge = new int[121];
        int[] countUnderAge = new int[121];
        // count the number of people at age i
        for (int age : ages) {
            withSameAge[age]++;
        }
        // count number of people under(inclusive) age i
        for (int i = 1; i < 121; i++) {
            countUnderAge[i] = countUnderAge[i - 1] + withSameAge[i];
        }

        int count = 0;
        // (A/2+7, A] to satisfy this condition, we need to start with A > 14
        for (int i = 15; i < 121; i++) {
            if (withSameAge[i] == 0) {
                continue;
            }
            count += withSameAge[i] * (countUnderAge[i] - countUnderAge[i / 2 + 7]) - withSameAge[i];
        }
        return count;
    }
}

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
