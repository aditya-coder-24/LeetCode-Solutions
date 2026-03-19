class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // add all heads
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            current.next = temp;
            current = current.next;

            if (temp.next != null) {
                pq.add(temp.next);
            }
        }

        return dummy.next;
    }
}