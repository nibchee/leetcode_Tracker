class Solution {
    int [][]dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        dp=new int[m][n];
       if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)
        return 0;
       return helper(m-1,n-1,m,n,obstacleGrid); 
    }
    private int helper(int i,int j,int m,int n,int[][]obstacleGrid){

        if( i<0 || j<0|| obstacleGrid[i][j]==1)
        return 0;

        if(i==0 && j==0)
        return 1;
         if(dp[i][j]!=0)
         return dp[i][j];  
        int up=helper(i-1,j,m,n,obstacleGrid);
        int left=helper(i,j-1,m,n,obstacleGrid);
       // System.out.println(i+" "+j+" "+up+" "+left);
        return dp[i][j] =up+left;
    }
}