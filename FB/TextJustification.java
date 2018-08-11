/* Note:
this solution is not accepted by leetcode, because we are aiming to distribute words
as even as possible, AKA to minimize the sum of square(extra space count in each line).
*/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int len = words.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = maxWidth - words[i].length();
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = dp[i][j - 1] - words[j].length() - 1;
            }
        }
        // square the cost to take care of evenly distribution spaces
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (dp[i][j] < 0) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else {
                    dp[i][j] = (int)Math.pow(dp[i][j], 2);
                }
            }
        }

        // use two arrays to keep track of costs and spliting index
        int[] minCost = new int[len];
        int[] splits = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            minCost[i] = dp[i][len - 1];
            splits[i] = len;
            for (int j = len - 1; j > i; j--) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (minCost[i] > minCost[j] + dp[i][j - 1]) {
                    minCost[i] = minCost[j] + dp[i][j - 1];
                    splits[i] = j;
                }
            }
        }

        // trackback the splits
        int i = 0, splitIdx = 0;
        do {
            splitIdx = splits[i];
            StringBuilder sb = new StringBuilder();
            for (int k = i; k < splitIdx; k++) {
                sb.append(words[k] + " ");
            }
            result.add(sb.toString());
            i = splitIdx;
        } while (splitIdx < len);

        return result;
    }
}
