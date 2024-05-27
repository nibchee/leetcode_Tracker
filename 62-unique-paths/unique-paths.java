class Solution {
    int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    dp[m - 1][n - 1] = 1;
                else {
                    int down = (i + 1 <= m - 1) ? dp[i + 1][j] : 0;
                    int right = (j + 1 <= n - 1) ? dp[i][j + 1] : 0;
                    dp[i][j] = down + right;
                }
            }
        }
        return dp[0][0];
    }

    private int helper(int row, int col, int m, int n) {
        if (row >= m || col >= n)
            return 0;
        if (row == m - 1 && col == n - 1)
            return 1;
        if (dp[row][col] != 0)
            return dp[row][col];
        int down = helper(row + 1, col, m, n);
        int right = helper(row, col + 1, m, n);
        return dp[row][col] = down + right;
    }
}