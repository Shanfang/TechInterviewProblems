class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, HashMap<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String str1 = equations[i][0];
            String str2 = equations[i][1];
            map.putIfAbsent(str1, new HashMap<>());
            map.putIfAbsent(str2, new HashMap<>());
            map.get(str1).put(str2, values[i]);
            map.get(str2).put(str1, 1 / values[i]);
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String str1 = queries[i][0];
            String str2 = queries[i][1];
            result[i] = dfs(str1, str2, 1, map, new HashSet<>());
        }
        return result;
    }

    private double dfs(String num1, String num2, double product, Map<String, HashMap<String, Double>> map, Set<String> set) {
        if (!map.containsKey(num1) || set.contains(num1)) {
            return -1;
        }
        set.add(num1);
        if (num1.equals(num2)) {
            return product;
        }
        for (String key : map.get(num1).keySet()) {
            double result = dfs(key, num2, product * map.get(num1).get(key), map, set);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }
}
