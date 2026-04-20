class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode smallDummy = new ListNode(0);
        ListNode bigDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode big = bigDummy;

        while (head != null) {

            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }

            head = head.next;
        }

        // important: end big list
        big.next = null;

        // connect both lists
        small.next = bigDummy.next;

        return smallDummy.next;
    }
}