import java.util.*;

class Solution {

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        // Pattern characters and words must have same count
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> patternToWord = new HashMap<>();
        Map<String, Character> wordToPattern = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            // Check pattern -> word
            if (patternToWord.containsKey(ch)) {

                if (!patternToWord.get(ch).equals(word)) {
                    return false;
                }

            } else {

                patternToWord.put(ch, word);
            }

            // Check word -> pattern
            if (wordToPattern.containsKey(word)) {

                if (wordToPattern.get(word) != ch) {
                    return false;
                }

            } else {

                wordToPattern.put(word, ch);
            }
        }

        return true;
    }
}