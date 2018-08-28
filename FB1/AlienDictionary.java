class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = buildGraph(words);
        return topologySort(graph);
    }

    private Map<Character, Set<Character>> buildGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String str : words) {
            for (char c : str.toCharArray()) {
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<Character>());
                }
            }
        }

        // two directions determine the order, downwards and rightwards
        for (int i = 0; i < words.length - 1; i++) {
            int minLen = Math.min(words[i].length(), words[i + 1].length());
            char[] chars1= words[i].toCharArray();
            char[] chars2 = words[i + 1].toCharArray();
            int index = 0;
            while (index < minLen) {
                if (chars1[index] != chars2[index]) {
                    graph.get(chars1[index]).add(chars2[index]);
                    break;
                }
                index++;
            }
        }
        return graph;
    }

    private String topologySort(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = findIndegree(graph);

        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character head = queue.poll();
            sb.append(head);
            for (char neighbor : graph.get(head)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        // Note: if there are disconnected component, it is not sortable
        if (sb.length() != indegree.size()) {
            return "";
        }
        return sb.toString();
    }

    private Map<Character, Integer> findIndegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();
        for (Character c : graph.keySet()) {
            if (!indegree.containsKey(c)) {
                indegree.put(c, 0);
            }
            Set<Character> neighbors = graph.get(c);
            for (Character neighbor : neighbors) {
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) + 1);
            }
        }
        return indegree;
    }
}
