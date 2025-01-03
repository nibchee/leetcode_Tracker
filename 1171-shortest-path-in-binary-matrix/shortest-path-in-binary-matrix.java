class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
       int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
        return -1;

        Queue<int[]> q=new LinkedList<>();
        int all_directions[][]={{1,1},{-1,-1},{1,0},{-1,0},{0,1},{0,-1},{1,-1},{-1,1}};
        q.add(new int[]{0,0});
        int path=1;

        while(!q.isEmpty()){
           int qSize=q.size();
           for(int i=0;i<qSize;i++){
            int[] ele=q.remove();
            if(ele[0]==n-1 && ele[1]==n-1)
            return path;
             for(int direction[]:all_directions)
                {
                    int x=ele[0]+direction[0];
                    int y=ele[1]+direction[1];
                    if(x>=0 && y>=0 && x<n && y<n && grid[x][y]==0)
                    {
                        q.add(new int[]{x,y});
                        grid[x][y]=-1;
                    }
                }

           }
           path++; 
        }
return -1;
    }
}