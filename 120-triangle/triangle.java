class Solution {
  int dp[][];

  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    dp = new int[n][n];
    for (int j = 0; j < n; j++) {
      dp[n - 1][j] = triangle.get(n - 1).get(j);
    }
    for (int i = n - 2; i >= 0; i--) {
      for (int j = n - 2; j >= 0; j--) {
        if (j <= i) {
          // take bottom
          int takeBelow = dp[i + 1][j] + triangle.get(i).get(j);
          // take i+1
          int takeBelowRight = dp[i + 1][j + 1] + triangle.get(i).get(j);
          dp[i][j] = Math.min(takeBelow, takeBelowRight);
        }
      }
    }
    return dp[0][0];
  }

  private int helper(int i, int j, List<List<Integer>> triangle) {
    if (i == triangle.size() - 1) {
      return triangle.get(i).get(j);
    }
    if (dp[i][j] != 0)
      return dp[i][j];
    // take bottom
    int takeBelow = helper(i + 1, j, triangle) + triangle.get(i).get(j);
    // take i+1
    int takeBelowRight = helper(i + 1, j + 1, triangle) + triangle.get(i).get(j);
    return dp[i][j] = Math.min(takeBelow, takeBelowRight);
  }
}