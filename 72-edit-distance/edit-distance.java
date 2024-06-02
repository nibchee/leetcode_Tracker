class Solution {
    int dp[][];

    private int helper(int i, int j, String word1, String word2) {
        // word1 got exhausted
        if (i < 0)
            return j + 1; // J+1 Insertion operations

        // word2 gets exhausted
        if (j < 0)
            return i + 1; // I+1 deletion operations

        if (dp[i][j] != -1)
            return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j))
            return dp[i][j] = helper(i - 1, j - 1, word1, word2);

        return dp[i][j] = 1 + Math.min(
                helper(i, j - 1, word1, word2), /** Insertion */
                Math.min(helper(i - 1, j, word1, word2), /** Deletion */
                        helper(i - 1, j - 1, word1, word2)/** Replace */
                ));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // if (m == 0)
        //     return n;
        // if (n == 0)
        //     return m;

        // dp = new int[m][n];
        // for (int[] arr : dp)
        // Arrays.fill(arr, -1);
        // return helper(m - 1, n - 1, word1, word2);

        // Applying Tabulation & f(0,0) ,f(0,1) => Shifting
        dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1 + dp[i - 1][0];
        }

        for (int i = 1; i <= n; i++)
            dp[0][i] = 1 + dp[0][i - 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // shifiting
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(
                            dp[i][j - 1], /** Insertion */
                            Math.min(dp[i - 1][j], /** Deletion */
                                    dp[i - 1][j - 1]/** Replace */
                            ));
            }
        }
        return dp[m][n];
    }
}