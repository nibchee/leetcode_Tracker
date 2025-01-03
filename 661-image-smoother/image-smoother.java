class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m=img.length;
        int n=img[0].length;
        int ans[][]=new int[m][n];
        int directions[][]={{0,0},{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            int sum=0;
            int count=0;
            for(int direction[]: directions){
                int x=i+direction[0];
                int y=j+direction[1];
                if(x>=0 && y>=0 && x<m && y<n){
                sum+=img[x][y];
                count++;
                }
            }
            ans[i][j]=sum/count;
         }
        }
 return ans;       
    }
}