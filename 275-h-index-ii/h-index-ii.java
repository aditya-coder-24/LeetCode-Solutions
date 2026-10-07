class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Number of papers from mid to the end
            int papers = n - mid;

            if (citations[mid] >= papers) {
                // Possible h-index, try to find a larger one
                right = mid - 1;
            } else {
                // Not enough citations
                left = mid + 1;
            }
        }

        return n - left;
    }
}