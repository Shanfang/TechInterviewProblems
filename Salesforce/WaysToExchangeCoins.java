import java.util.*;

class WaysToExchangeCoins {
    static List<List<Integer>> exchange(int[] coins, int amount) {
        List<List<Integer>> result = new ArrayList<>();
        if (coins == null || coins.length == 0) {
            return result;
        }
        Arrays.sort(coins);
        helper(coins, 0, 0, amount, new ArrayList<>(), result);
        return result;
    }

    private static void helper(int[] coins, int index, int cur, int amount,
                                List<Integer> list, List<List<Integer>> result) {
        if (cur == amount) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (cur > amount) {
            return;
        }
        for (int i = index; i < coins.length; i++) {
            list.add(coins[i]);
            helper(coins, i, cur + coins[i], amount, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] coins = {1,5,10,25};
        for(List<Integer> list : exchange(coins, 25)) {
            for (int num : list) {
                System.out.print(num + "  ");
            }
            System.out.println("");
        }
    }
}
