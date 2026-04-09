class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // find length
        ListNode temp = head;
        int length = 1;

        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // connect last node to head (circular)
        temp.next = head;

        // reduce k
        k = k % length;

        int steps = length - k;

        ListNode newTail = temp;

        while (steps > 0) {
            newTail = newTail.next;
            steps--;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}