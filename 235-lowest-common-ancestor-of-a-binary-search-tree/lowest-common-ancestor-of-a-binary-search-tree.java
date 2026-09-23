class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            // Both nodes are in the left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }

            // Both nodes are in the right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }

            // Nodes are on different sides, or root is p/q
            else {
                return root;
            }
        }

        return null;
    }
}