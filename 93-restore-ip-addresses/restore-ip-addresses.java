import java.util.*;

class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, "", result);
        return result;
    }

    private void backtrack(String s, int index, int parts,
                           String path, List<String> result) {

        // base case
        if (parts == 4 && index == s.length()) {
            result.add(path.substring(0, path.length() - 1)); // remove last dot
            return;
        }

        // invalid case
        if (parts == 4 || index == s.length()) return;

        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) break;

            String segment = s.substring(index, index + len);

            // check leading zero
            if (segment.length() > 1 && segment.charAt(0) == '0')
                continue;

            int value = Integer.parseInt(segment);

            if (value <= 255) {
                backtrack(s, index + len, parts + 1,
                          path + segment + ".", result);
            }
        }
    }
}