public class Solution {
    public boolean isPalindrome(int x) {
        
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int rev = 0;
        while (x > rev) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10;
        }
        return (x == rev || x == rev / 10);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(121));   
        System.out.println(sol.isPalindrome(-121));  
        System.out.println(sol.isPalindrome(10)); 
        System.out.println(sol.isPalindrome(0));  
    }
}
