import java.util.*;

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // important

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int start, int[] nums,
                           List<Integer> temp,
                           List<List<Integer>> result) {

        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {

            // skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            temp.add(nums[i]);
            backtrack(i + 1, nums, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}