// use topology sorting
class Solution {
    public String alienOrder(String[] words) {
        // construct a graph for the words
        Map<Character, Set<Character>> graph = buildGraph(words);

        // topology sorting to find order
        return topoSort(graph);
    }

    private Map<Character, Set<Character>> buildGraph(String[] words) {
        // get nodes for the graph
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<Character>());
                }
            }
        }

        // set edges for the graph
        for (int i = 0; i < words.length - 1; i++) {
            int len = Math.min(words[i].length(), words[i + 1].length());
            int index = 0;
            while (index < len) {
                char c1 = words[i].charAt(index);
                char c2 = words[i + 1].charAt(index);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    break;
                }
                index++;
            }
        }
        return graph;
    }

    private String topoSort(Map<Character, Set<Character>> graph) {
        // find indegree for each node
        Map<Character, Integer> indegree = new HashMap<>();
        for (char key : graph.keySet()) {
            indegree.put(key, 0);
        }

        for (char key : graph.keySet()) {
            for (char neighbor : graph.get(key)) {
                if (!indegree.containsKey(neighbor)) {
                    indegree.put(neighbor, 0);
                }
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }


        // offer those nodes with indegree = 0 onto queue
        Queue<Character> queue = new PriorityQueue<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        // sort starts
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            sb.append(cur);

            Set<Character> neighbors = graph.get(cur);
            for (char neighbor : neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (sb.length() != indegree.size()) {
            return "";
        }
        return sb.toString();
    }
}
