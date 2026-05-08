class Solution {

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) return null;

        // single node
        if (head.next == null)
            return new TreeNode(head.val);

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        // find middle
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // cut left half
        prev.next = null;

        // middle becomes root
        TreeNode root = new TreeNode(slow.val);

        // build left subtree
        root.left = sortedListToBST(head);

        // build right subtree
        root.right = sortedListToBST(slow.next);

        return root;
    }
}