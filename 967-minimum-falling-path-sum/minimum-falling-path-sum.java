class Solution {
    int dp[][];

    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];
        for (int i = 0; i < n; i++) {
           dp[0][i]=matrix[0][i];
        }
        
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
               int up=dp[i-1][j];
               int leftDiag=(j-1)>=0?dp[i-1][j-1]:Integer.MAX_VALUE;
               int rightDiag=(j+1)<n?dp[i-1][j+1]:Integer.MAX_VALUE;

               dp[i][j]=Math.min(up,Math.min(leftDiag,rightDiag))+matrix[i][j];
            }
        }
              
    //    for(int i=0;i<m;i++){
    //     for(int j=0;j<n;j++)
    //     System.out.print(dp[i][j]+" ");
    //     System.out.println();
    //    }
              
        for(int i=0;i<n;i++){
            min=Math.min(dp[m-1][i],min);
        }
        return min;
    }

    private int helper(int i, int j, int[][] matrix) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length)
            return Integer.MAX_VALUE;
        // base case
        if (i == 0)
            return matrix[i][j];
        if (dp[i][j] != 0)
            return dp[i][j];
        int diagLeft = helper(i - 1, j - 1, matrix);
        int straightUp = helper(i - 1, j, matrix);
        int diagRight = helper(i - 1, j + 1, matrix);
        return dp[i][j] = Math.min(diagLeft, Math.min(straightUp, diagRight)) + matrix[i][j];
    }
}