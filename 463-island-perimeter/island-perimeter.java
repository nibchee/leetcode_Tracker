class Solution {
    int perimeter=0;
    public int islandPerimeter(int[][] grid) {
           
           for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                dfs(grid,i,j);
            }
           }
           return perimeter;
    }

    public void dfs(int grid[][],int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]==-1 || grid[i][j]==0)
        return;

        grid[i][j]=-1;
        int c=0;
        if(i-1>=0 && grid[i-1][j]!=0)
        c++;
        
        if(i+1<grid.length && grid[i+1][j]!=0)
        c++;

        if(j-1>=0 && grid[i][j-1]!=0)
        c++;

        if(j+1<grid[i].length && grid[i][j+1]!=0)
        c++;
        
       perimeter+=(4-c);
       dfs(grid,i+1,j);
       dfs(grid,i-1,j);
       dfs(grid,i,j+1);
       dfs(grid,i,j-1);
         
    }
}