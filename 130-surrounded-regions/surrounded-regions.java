class Solution {
    public void solve(char[][] grid) {
        //dfs on top boundary
        for(int j=0;j<grid[0].length;j++){
            if(grid[0][j]!='V' && grid[0][j]!='X')
            dfs(0,j,grid);
        }

        //dfs on left boundary
        for(int i=1;i<grid.length;i++){
            if(grid[i][0]!='V' && grid[i][0]!='X')
            dfs(i,0,grid);
        }

        //dfs on right boundary
        for(int i=1;i<grid.length;i++){
        if(grid[i][grid[0].length-1]!='V' && grid[i][grid[0].length-1]!='X')
            dfs(i,grid[0].length-1,grid);
        }
                   

        //dfs on bottom boundaries
        for(int j=0;j<grid[0].length;j++){
            if(grid[grid.length-1][j]!='V' && grid[grid.length-1][j]!='X')
            dfs(grid.length-1,j,grid);           

        }

         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='O')
                grid[i][j]='X';
                if(grid[i][j]=='V')
                grid[i][j]='O';
            }
         }
    
    }

    public void dfs(int i,int j,char[][]grid){
        if(i<0 || i>=grid.length||j<0 ||j>=grid[0].length||grid[i][j]=='X' || grid[i][j]=='V')
        return;
        grid[i][j]='V';
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}