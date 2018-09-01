class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            map.putIfAbsent(equations[i][0], new HashMap<>());
            map.putIfAbsent(equations[i][1], new HashMap<>());
            map.get(equations[i][0]).put(equations[i][1], values[i]);
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (!map.containsKey(queries[i][0])) {
                result[i] = -1;
                continue;
            }
            result[i] = dfs(queries[i][0], queries[i][1], 1, map, new HashSet<>());
        }
        return result;
    }

    private double dfs(String numerator, String denominator, double product, Map<String, Map<String, Double>> map, Set<String> usedNumerator) {
        if (!map.containsKey(numerator) || !usedNumerator.add(numerator)) {
            return -1;
        }
        if (numerator.equals(denominator)) {
            return product;
        }
        for (String str : map.get(numerator).keySet()) {
            double result = dfs(str, denominator, product * map.get(numerator).get(str), map, usedNumerator);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }
}
