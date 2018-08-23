class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }

        int height = wall.size();
        int leastCut = height;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int len = 0;
            List<Integer> row = wall.get(i);
            for (int j = 0; j < row.size() - 1; j++) {
                len += row.get(j);
                map.put(len, map.getOrDefault(len, 0) + 1);
            }
        }

        // find the len with most rows crossing that length

        for (int key : map.keySet()) {
            leastCut = Math.min(leastCut, height - map.get(key));
        }
        return leastCut;
    }
}
