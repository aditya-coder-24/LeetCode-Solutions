import java.util.*;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int num = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            else if (ch == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            }

            else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            }

            else if (ch == '(') {
                // Save current result and sign
                stack.push(result);
                stack.push(sign);

                // Start a new calculation inside parentheses
                result = 0;
                sign = 1;
            }

            else if (ch == ')') {
                // Add the last number inside parentheses
                result += sign * num;
                num = 0;

                // Get sign before '('
                int previousSign = stack.pop();

                // Get result before '('
                int previousResult = stack.pop();

                result = previousResult + previousSign * result;
            }
        }

        // Add the last number
        result += sign * num;

        return result;
    }
}