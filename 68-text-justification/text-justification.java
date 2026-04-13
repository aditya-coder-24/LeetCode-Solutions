import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {

            int j = i;
            int lineLength = 0;

            // Step 1: pick words
            while (j < words.length &&
                   lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            // Step 2: last line or single word
            if (j == words.length || gaps == 0) {

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1)
                        line.append(" ");
                }

                // fill remaining spaces
                while (line.length() < maxWidth)
                    line.append(" ");
            }

            // Step 3: fully justify
            else {

                int totalSpaces = maxWidth - lineLength;
                int space = totalSpaces / gaps;
                int extra = totalSpaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        int spacesToApply = space + (extra-- > 0 ? 1 : 0);

                        for (int s = 0; s < spacesToApply; s++)
                            line.append(" ");
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}