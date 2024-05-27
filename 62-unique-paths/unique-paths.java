class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        return helper(0, 0, m, n);
    }

    private int helper(int row, int col, int m, int n) {
        if (row >= m || col >= n)
            return 0;
        if (row == m - 1 && col == n - 1)
            return 1;
        if(dp[row][col]!=0) return dp[row][col];
        int down = helper(row + 1, col, m, n);
        int right = helper(row, col + 1, m, n);
        return dp[row][col]=down+right;
    }
}