class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            // check if duplicate exists
            if (curr.next != null && curr.val == curr.next.val) {

                // skip all duplicates
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }

                // remove all duplicates
                prev.next = curr.next;
            } 
            else {
                prev = prev.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}