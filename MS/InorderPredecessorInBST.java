TreeNode predecessor(TreeNode root, TreeNode p) {
    if (root == null) {
        return null;
    }
    if (root.val >= p.val) {
        return predecessor(root.left, p);
    } else {
        TreeNode candidate = predecessor(root.right, p);
        return candidate == null ? root : candidate;
    }
}
