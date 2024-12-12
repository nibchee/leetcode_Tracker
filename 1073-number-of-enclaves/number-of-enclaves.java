class Solution {
    public int numEnclaves(int[][] grid) {

        //dfs on top boundary
        for(int j=0;j<grid[0].length;j++){
            if(grid[0][j]!=-1 && grid[0][j]!=0)
            dfs(0,j,grid);
        }

        //dfs on left boundary
        for(int i=1;i<grid.length;i++){
            if(grid[i][0]!=-1 && grid[i][0]!=0)
            dfs(i,0,grid);
        }

        //dfs on right boundary
        for(int i=1;i<grid.length;i++){
        if(grid[i][grid[0].length-1]!=-1 && grid[i][grid[0].length-1]!=0)
            dfs(i,grid[0].length-1,grid);
        }
                   

        //dfs on bottom boundaries
        for(int j=0;j<grid[0].length;j++){
            if(grid[grid.length-1][j]!=-1 && grid[grid.length-1][j]!=0)
            dfs(grid.length-1,j,grid);           

        }

         int ans=0;
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1)
                ans++;
            }
         }
    return ans;
    }

    public void dfs(int i,int j,int[][]grid){
        if(i<0 || i>=grid.length||j<0 ||j>=grid[0].length||grid[i][j]==0 || grid[i][j]==-1)
        return;
        grid[i][j]=-1;
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}