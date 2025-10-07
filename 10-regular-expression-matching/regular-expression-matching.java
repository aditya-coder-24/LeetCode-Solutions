class Solution {
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true; 
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                if (j >= 2) {
                    dp[0][j] = dp[0][j - 2];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    if (j >= 2) {
                        dp[i][j] = dp[i][j - 2];
                    }

                    if (j >= 2 && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1))) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));       
        System.out.println(isMatch("aa", "a*"));       
        System.out.println(isMatch("ab", ".*"));       
        System.out.println(isMatch("mississippi", "mis*is*p*.")); 
        System.out.println(isMatch("aab", "c*a*b"));   
    }
}
