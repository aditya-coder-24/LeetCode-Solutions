import java.util.*;

class Solution {

    private int postIndex;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        // store inorder indices
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {

        if (left > right) return null;

        // root from postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // find root in inorder
        int inorderIndex = inorderMap.get(rootVal);

        // IMPORTANT:
        // build right first
        root.right = build(postorder, inorderIndex + 1, right);

        root.left = build(postorder, left, inorderIndex - 1);

        return root;
    }
}