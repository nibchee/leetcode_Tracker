class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        dp=new int[m][n];

        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
            if(i==0 && j==0){
                dp[i][j]=grid[i][j];
            }else{
                int left=(j-1)>=0? dp[i][j-1]:Integer.MAX_VALUE;
                int up=(i-1)>=0?dp[i-1][j]:Integer.MAX_VALUE;
                dp[i][j]=Math.min(left,up)+grid[i][j];
            }
           }
        }
        //return helper(m-1,n-1,grid);
        return dp[m-1][n-1];
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