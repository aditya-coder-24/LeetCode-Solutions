class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {

        // Area of first rectangle
        long area1 = (long) (ax2 - ax1) * (ay2 - ay1);

        // Area of second rectangle
        long area2 = (long) (bx2 - bx1) * (by2 - by1);

        // Find overlapping boundaries
        int overlapLeft = Math.max(ax1, bx1);
        int overlapRight = Math.min(ax2, bx2);
        int overlapBottom = Math.max(ay1, by1);
        int overlapTop = Math.min(ay2, by2);

        long overlapArea = 0;

        // Check if rectangles actually overlap
        if (overlapLeft < overlapRight && overlapBottom < overlapTop) {
            overlapArea = (long) (overlapRight - overlapLeft)
                        * (overlapTop - overlapBottom);
        }

        return (int) (area1 + area2 - overlapArea);
    }
}