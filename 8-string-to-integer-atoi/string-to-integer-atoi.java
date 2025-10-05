public class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        int num = 0;

        while (i < n && s.charAt(i) == ' ') i++;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (num > Integer.MAX_VALUE / 10 ||
                (num == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }

        return num * sign;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("42"));             
        System.out.println(sol.myAtoi("   -42"));         
        System.out.println(sol.myAtoi("4193 with words"));
        System.out.println(sol.myAtoi("words 987"));     
        System.out.println(sol.myAtoi("-91283472332")); 
    }
}
