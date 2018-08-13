class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);

        // find indegrees for each course node,
        // thouse courses have no prerequistes does not appear in this map as key
        Map<Integer, Integer> indegrees = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            for (int course : graph.get(i)) {
                if (indegrees.containsKey(course)) {
                    indegrees.put(course, indegrees.get(course) + 1);
                } else {
                    indegrees.put(course, 1);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (!indegrees.containsKey(i)) {
                queue.offer(i);
                count++;
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;
            for (int post : graph.get(course)) {
                int newIn = indegrees.get(post) - 1;
                indegrees.put(post, newIn);
                if (newIn == 0) {
                    queue.offer(post);
                    count++;
                }
            }
        }
        if(count != numCourses) {
            return new int[0];
        }
        return order;
    }



    private Map<Integer, List<Integer>> buildGraph(int num, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < num; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int post = prerequisites[i][0];
            graph.get(pre).add(post);
        }
        return graph;
    }
}
