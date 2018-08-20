// use union find
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] roots = new int[n];
        Arrays.fill(roots, -1);

        for (int i = 0; i < edges.length; i++) {
            int root1 = findRoot(roots, edges[i][0]);
            int root2 = findRoot(roots, edges[i][1]);
            if (root1 == root2) {
                return false;
            }
            roots[root1] = root2;
        }
        return edges.length == n - 1;
    }

    private int findRoot(int[] roots, int node) {
        if (roots[node] == -1) {
            return node;
        }
        return findRoot(roots, roots[node]);
    }
}
