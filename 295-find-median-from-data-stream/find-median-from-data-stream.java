import java.util.*;

class MedianFinder {

    // Smaller half
    private PriorityQueue<Integer> left;

    // Larger half
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Add to left first
        left.offer(num);

        // Make sure every element in left <= every element in right
        if (!left.isEmpty() && !right.isEmpty()
                && left.peek() > right.peek()) {

            right.offer(left.poll());
        }

        // Balance the sizes
        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        }

        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() == right.size()) {
            return ((double) left.peek() + right.peek()) / 2;
        }

        return left.peek();
    }
}