class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length();
        int n = s2.length();

        // Length check
        if (m + n != s3.length()) {
            return false;
        }

        // dp[j] = whether s3 can be formed using
        // s1[0...i-1] and s2[0...j-1]
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        // Initialize first row
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] &&
                    s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {

            // Initialize first column
            dp[0] = dp[0] &&
                    s1.charAt(i - 1) == s3.charAt(i - 1);

            for (int j = 1; j <= n; j++) {

                dp[j] =
                    (dp[j] &&
                     s1.charAt(i - 1) == s3.charAt(i + j - 1))
                    ||
                    (dp[j - 1] &&
                     s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[n];
    }
}