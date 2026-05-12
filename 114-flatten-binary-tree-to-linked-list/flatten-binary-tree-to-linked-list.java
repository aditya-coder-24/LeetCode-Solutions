class Solution {

    public void flatten(TreeNode root) {

        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        // move left subtree to right
        root.left = null;
        root.right = left;

        // go to end of new right subtree
        TreeNode current = root;

        while (current.right != null) {
            current = current.right;
        }

        // attach original right subtree
        current.right = right;
    }
}