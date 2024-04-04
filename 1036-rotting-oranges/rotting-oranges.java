class Solution {

    private boolean isSafe(int i,int j,int r,int c){
        return (i>=0 && j>=0  && i<r && j<c);
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        int freshOrange=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                  }
                     if(grid[i][j]==1)
                    freshOrange++;
               
            }
        }
        if(freshOrange==0)return 0;
        if(q.isEmpty())return -1;

        int min=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int []cell=q.remove();
                int x=cell[0];
                int y=cell[1];
                //up
                if(isSafe(x-1,y,m,n) && grid[x-1][y]==1){
                    grid[x-1][y]=2;
                    q.add(new int[]{x-1,y});
                    freshOrange--;
                }
                //down
                if(isSafe(x+1,y,m,n) && grid[x+1][y]==1){
                    grid[x+1][y]=2;
                    q.add(new int[]{x+1,y});
                    freshOrange--;
                }
                //left
                if(isSafe(x,y-1,m,n) && grid[x][y-1]==1){
                    grid[x][y-1]=2;
                    q.add(new int[]{x,y-1});
                    freshOrange--;
                }
                //right
                if(isSafe(x,y+1,m,n) && grid[x][y+1]==1){
                    grid[x][y+1]=2;
                    q.add(new int[]{x,y+1});
                    freshOrange--;
                }
            }
            min++;
        }

        if(freshOrange==0)
        return min-1;

    return -1;
    }
}