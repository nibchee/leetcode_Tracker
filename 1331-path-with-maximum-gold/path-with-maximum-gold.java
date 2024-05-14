class Solution {
    int ans=0;
    public int getMaximumGold(int[][] grid) {
     int m=grid.length;
     int n=grid[0].length;
     int sum=0;
     for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]!=0){
               dfs(grid,i,j,sum);
            }
        }
     }
     return ans;   
    }
    
    public void dfs(int [][]grid,int i,int j,int sum){
      ans=Math.max(ans,sum);
      if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0)
      return;
        
        int val=grid[i][j];
        sum+=val;
        grid[i][j]=0;
        dfs(grid,i,j+1,sum);
        dfs(grid,i,j-1,sum);
        dfs(grid,i+1,j,sum);
        dfs(grid,i-1,j,sum);
       grid[i][j]=val;
       //sum-=val;
    }

}