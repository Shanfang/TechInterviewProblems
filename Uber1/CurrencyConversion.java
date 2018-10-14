import java.util.*;

class CurrencyConversion {
    private static Map<String, HashMap<String, Double>> map;
    private static Set<String> currencies;
    CurrencyConversion () {
        this.map = new HashMap<>();
        this.currencies = new HashSet<>();
    }
    public static void update(String cur1, String cur2, double rate) {
        map.putIfAbsent(cur1, new HashMap<>());
        map.putIfAbsent(cur2, new HashMap<>());
        map.get(cur1).put(cur2, rate);
        map.get(cur2).put(cur1, 1 / rate);
        currencies.add(cur1);
        currencies.add(cur2);
    }
    public static double convert(String cur1, String cur2, double amt) {
        if (!currencies.contains(cur1) || !currencies.contains(cur2)) {
            return -1;
        }
        double result = -1;
        result = amt * helper(cur1, cur2, 1, map, new HashSet<>());
        return result;
    }

    private static double helper(String cur1, String cur2, double product, Map<String, HashMap<String, Double>> map, Set<String> set) {
        if (set.contains(cur1) || !map.containsKey(cur1)) {
            return -1;
        }
        if (cur1.equals(cur2)) {
            return product;
        }
        set.add(cur1);
        double result = -1;
        for (String str : map.get(cur1).keySet()) {
            result = helper(str, cur2, product * map.get(cur1).get(str), map, set);
            if (result != -1) {
                return result;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        CurrencyConversion conv = new CurrencyConversion();
        conv.update("USD", "CNY", 6.8);
        conv.update("CNY", "KRW", 20.0);
        double rst1 = conv.convert("USD", "CNY", 1);
        double rst2 = conv.convert("USD", "KRW", 1);
        double rst3 = conv.convert("KRW", "CNY", 1);
        System.out.println(rst1);
        System.out.println(rst2);
        System.out.println(rst3);
    }
}
