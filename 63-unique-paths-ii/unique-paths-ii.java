class Solution {
    int [][]dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        dp=new int[m][n];
       if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)
        return 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                dp[i][j]=0;
                continue;
                }
                if(i==0 && j==0){
                    dp[i][j]=1;
                }else{
                        int left=(j-1)>=0 ? dp[i][j-1]:0;
                        int up=(i-1)>=0 ?dp[i-1][j]:0;
                       // System.out.println(left+" L "+up+" U ");
                        dp[i][j]=left+up;
                }
               // System.out.print(dp[i][j]+" ");
            }
           // System.out.println();
        }
       //return helper(m-1,n-1,m,n,obstacleGrid); 
       return dp[m-1][n-1];
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