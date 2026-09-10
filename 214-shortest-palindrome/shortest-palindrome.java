class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String reversed = new StringBuilder(s).reverse().toString();

        // Create: s + "#" + reversed
        String combined = s + "#" + reversed;

        // Build LPS array
        int[] lps = new int[combined.length()];

        for (int i = 1; i < combined.length(); i++) {
            int j = lps[i - 1];

            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }

            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        // Length of longest palindromic prefix
        int palindromeLength = lps[combined.length() - 1];

        // Characters after the palindrome
        String remaining = s.substring(palindromeLength);

        // Add their reverse to the front
        return new StringBuilder(remaining)
                .reverse()
                .toString() + s;
    }
}