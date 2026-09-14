import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            // Remove elements outside the index window
            if (i > indexDiff) {
                set.remove((long) nums[i - indexDiff - 1]);
            }

            long current = nums[i];

            // Find the smallest value >= current - valueDiff
            Long ceiling = set.ceiling(current - valueDiff);

            // Check if it is also <= current + valueDiff
            if (ceiling != null && ceiling <= current + valueDiff) {
                return true;
            }

            set.add(current);
        }

        return false;
    }
}