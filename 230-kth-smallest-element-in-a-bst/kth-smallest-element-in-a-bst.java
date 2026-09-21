import java.util.*;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (true) {
            // Go as far left as possible
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Get the next smallest node
            current = stack.pop();
            k--;

            if (k == 0) {
                return current.val;
            }

            // Move to right subtree
            current = current.right;
        }
    }
}