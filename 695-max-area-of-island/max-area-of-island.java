class Solution {
    int tempArea=0;
    public int maxAreaOfIsland(int[][] grid) {
          int maxArea=0;       
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                 tempArea=0;
                 dfs(grid, i, j);
                 maxArea=Math.max(tempArea,maxArea);
                }
            }
        }
        return maxArea;
    }

     private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[i].length - 1 || grid[i][j] == 0)
            return ;
        tempArea++;
        grid[i][j] = 0;
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
         dfs(grid, i, j - 1);
         dfs(grid, i + 1, j);
    }
}