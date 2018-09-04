class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = buildGraph(numCourses, prerequisites);

        return topologySort(graph);
    }

    private Map<Integer, Set<Integer>> buildGraph(int courses, int[][] pres) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < courses; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < pres.length; i++) {
            graph.get(pres[i][0]).add(pres[i][1]);
            // be careful abou the input, it is a list of pairs!!!
            
            // for (int j = 0; j < pres[i].length; j++) {
            //     graph.get(i).add(j);
            // }
        }
        return graph;
    }

    private boolean topologySort(Map<Integer, Set<Integer>> graph) {
        int size = graph.size();
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
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int next : graph.get(course)) {
                indegrees.put(next, indegrees.get(next) - 1);
                if (indegrees.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == size;
    }
}
