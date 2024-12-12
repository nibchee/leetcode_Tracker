class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int oldcolor=image[sr][sc];
        dfs(image,sr,sc,color,oldcolor);
        return image;
    }

    private void dfs(int[][]img,int i,int j,int color,int oldcolor){
        if(i<0 || i>=img.length || j<0 || j>=img[0].length || img[i][j]==color|| img[i][j]!=oldcolor)
        return;

        img[i][j]=color;
        dfs(img,i-1,j,color,oldcolor);
        dfs(img,i+1,j,color,oldcolor);
        dfs(img,i,j-1,color,oldcolor);
        dfs(img,i,j+1,color,oldcolor);
    }


}