class Solution {

    public Node connect(Node root) {

        Node current = root;

        while (current != null) {

            Node head = null; // head of next level
            Node prev = null; // previous node in next level

            while (current != null) {

                // process left child
                if (current.left != null) {
                    if (prev != null) {
                        prev.next = current.left;
                    } else {
                        head = current.left;
                    }
                    prev = current.left;
                }

                // process right child
                if (current.right != null) {
                    if (prev != null) {
                        prev.next = current.right;
                    } else {
                        head = current.right;
                    }
                    prev = current.right;
                }

                // move in current level
                current = current.next;
            }

            // move to next level
            current = head;
        }

        return root;
    }
}