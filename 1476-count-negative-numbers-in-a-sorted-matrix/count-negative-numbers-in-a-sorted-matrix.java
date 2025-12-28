class Solution {
    public int countNegatives(int[][] grid) {
      int row=grid.length-1;
      int col=0;
      int count=0;
      while(row>=0 && col<grid[0].length){
        if(grid[row][col]>=0){
            col++;
        }else{
        count+=(grid[0].length-col);
        row--;
        }
      }  
    return count;
    }

}