class Pair {
    int height;
    boolean isBalanced;
    Pair(int h, boolean balanced) {
        height = h;
        isBalanced = balanced;
    }
}

public boolean isBalanced (TreeNode root) {
    if (root == null) {
        return true;
    }

    return helper(root).isBalanced;
}

private Pair helper(TreeNode root) {
    if (root == null) {
        return new Pair(0, true);
    }

    Pair leftSub = helper(root.left);
    Pair rightSub = helper(root.right);
    if (!leftSub.isBalanced || !rightSub.isBalanced) {
        return new Pair(0, false);
    }
    if (Math.abs(leftSub.height - rightSub.height) > 1) {
        return new Pair(0, 0, false);
    }
    return new Pair(Math.max(leftSub.height, rightSub.height), true);
}
