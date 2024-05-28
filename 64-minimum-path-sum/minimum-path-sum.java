class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        dp=new int[m][n];
        return helper(m-1,n-1,grid);
    }

    private int helper(int i,int j,int[][]grid){
        if(i==0 && j==0)
        return grid[0][0];
        if(i<0 || j<0)
        return Integer.MAX_VALUE;
        if(dp[i][j]!=0){
         return dp[i][j];
        }
        int left=helper(i,j-1,grid);
        int up=helper(i-1,j,grid);
        return dp[i][j]=Math.min(left,up)+grid[i][j];
    } 
}