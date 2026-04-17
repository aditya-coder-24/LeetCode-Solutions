class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums,
                           List<Integer> temp,
                           List<List<Integer>> result) {

        // add current subset
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);                    // choose
            backtrack(i + 1, nums, temp, result); // explore
            temp.remove(temp.size() - 1);         // backtrack
        }
    }
}