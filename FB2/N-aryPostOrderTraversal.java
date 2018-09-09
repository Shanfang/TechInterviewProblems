/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        helper(root, result);
        return result;
    }

    private void helper(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            helper(child, list);
        }
        list.add(root.val);
    }
}
