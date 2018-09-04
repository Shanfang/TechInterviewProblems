class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = buildGraph(numCourses, prerequisites);
        List<Integer> list = new ArrayList<>();
        topologySort(graph, list);

        if (list.size() != numCourses) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            result[index++] = list.get(i);
        }
        return result;
    }

    private Map<Integer, Set<Integer>> buildGraph(int courses, int[][] pres) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < courses; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < pres.length; i++) {
            graph.get(pres[i][1]).add(pres[i][0]);
        }
        return graph;
    }

    private void topologySort(Map<Integer, Set<Integer>> graph, List<Integer> list) {
        Map<Integer, Integer> indegrees = new HashMap<>();
        for (int course : graph.keySet()) {
            if (!indegrees.containsKey(course)) {
                indegrees.put(course, 0);
            }
            for (int next : graph.get(course)) {
                indegrees.put(next, indegrees.getOrDefault(next, 0) + 1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int course : indegrees.keySet()) {
            if (indegrees.get(course) == 0) {
                queue.offer(course);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            list.add(course);
            for (int next : graph.get(course)) {
                indegrees.put(next, indegrees.get(next) - 1);
                if (indegrees.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
