class Solution {

    public int minDepth(TreeNode root) {

        if (root == null) return 0;

        // leaf node
        if (root.left == null && root.right == null)
            return 1;

        // if left missing
        if (root.left == null)
            return 1 + minDepth(root.right);

        // if right missing
        if (root.right == null)
            return 1 + minDepth(root.left);

        return 1 + Math.min(
                minDepth(root.left),
                minDepth(root.right)
        );
    }
}