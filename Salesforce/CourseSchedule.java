class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);
        return topologicalSort(numCourses, graph);
    }

    private Map<Integer, List<Integer>> buildGraph(int n, int[][] pres) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < pres.length; i++) {
            int pre = pres[i][1];
            int post = pres[i][0];
            graph.get(pre).add(post);
        }
        return graph;
    }

    private boolean topologicalSort(int n, Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> indegrees = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!indegrees.containsKey(i)) {
                indegrees.put(i, 0);
            }
            for (int next : graph.get(i)) {
                indegrees.put(next, indegrees.getOrDefault(next, 0) + 1);
            }
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int course : indegrees.keySet()) {
            if (indegrees.get(course) == 0) {
                queue.offer(course);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int next : graph.get(course)) {
                indegrees.put(next, indegrees.get(next) - 1);
                if (indegrees.get(next) == 0) {
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count == n;
    }
}
