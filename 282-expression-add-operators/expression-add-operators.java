import java.util.*;

class Solution {

    public List<String> addOperators(String num, int target) {

        List<String> result = new ArrayList<>();

        backtrack(
            num,
            target,
            0,
            0,
            0,
            "",
            result
        );

        return result;
    }

    private void backtrack(
            String num,
            long target,
            int index,
            long value,
            long prev,
            String expression,
            List<String> result) {

        // We have used all digits
        if (index == num.length()) {

            if (value == target) {
                result.add(expression);
            }

            return;
        }

        // Try every possible number starting at index
        for (int i = index; i < num.length(); i++) {

            // Avoid numbers with leading zeros
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            String currentString = num.substring(index, i + 1);

            long current = Long.parseLong(currentString);

            // First number
            if (index == 0) {

                backtrack(
                    num,
                    target,
                    i + 1,
                    current,
                    current,
                    currentString,
                    result
                );

            } else {

                // +
                backtrack(
                    num,
                    target,
                    i + 1,
                    value + current,
                    current,
                    expression + "+" + currentString,
                    result
                );

                // -
                backtrack(
                    num,
                    target,
                    i + 1,
                    value - current,
                    -current,
                    expression + "-" + currentString,
                    result
                );

                // *
                backtrack(
                    num,
                    target,
                    i + 1,
                    value - prev + (prev * current),
                    prev * current,
                    expression + "*" + currentString,
                    result
                );
            }
        }
    }
}