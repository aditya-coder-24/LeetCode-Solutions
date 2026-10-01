class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        // XOR of all numbers = a ^ b
        for (int num : nums) {
            xor ^= num;
        }

        // Find a bit where a and b are different
        int diffBit = xor & -xor;

        int num1 = 0;
        int num2 = 0;

        // Divide numbers into two groups
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }
}
