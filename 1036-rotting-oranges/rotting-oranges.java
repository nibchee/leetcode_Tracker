class Solution {
    int unrotten = 0;

    public int orangesRotting(int[][] grid) {
           int rotten = 0;
 
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    unrotten++;
                if (grid[i][j] == 2)
                    rotten++;
            }
        }
        if (unrotten>0 && rotten==0)
            return -1;

            if(unrotten==0)
            return 0;

        int ans = 0;
        int rot_mark = 3;
        while (true) {
            int rotten2=rott(grid, rot_mark,rotten);
            if (unrotten == 0) {
                return ans + 1;
            }
            if (rotten2 == rotten) {
                return -1;
            }
            ans++;
            rot_mark++;
            rotten=rotten2;
        }
    }

    private int rott(int[][]grid,int mark,int rotten){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]!=0 && grid[i][j]!=1 && grid[i][j]!=mark){
                    if(i-1>=0 && grid[i-1][j]==1){
                        grid[i-1][j]=mark;
                        rotten++;
                        unrotten--;
                    }
                       if(i+1<grid.length && grid[i+1][j]==1){
                        grid[i+1][j]=mark;
                        rotten++;
                        unrotten--;
                    }

                    
                       if(j+1<grid[i].length && grid[i][j+1]==1){
                        grid[i][j+1]=mark;
                        rotten++;
                        unrotten--;
                    }

                    
                       if(j-1>=0 && grid[i][j-1]==1){
                        grid[i][j-1]=mark;
                        rotten++;
                        unrotten--;
                    }
                }
            }
        }
        return rotten;
    }
}