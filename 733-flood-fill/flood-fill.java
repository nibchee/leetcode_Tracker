class Solution {
    private void dfs(int [][]image,int cr, int cc,int color,int pixel_color){
        //System.out.println(cr+" "+cc);
     if(cr<0 || cc<0 || cr>image.length-1 || cc>image[cr].length-1 || image[cr][cc]==color || image[cr][cc]!=pixel_color){
        return;
     }
    
     image[cr][cc]=color;
     dfs(image,cr,cc+1,color,pixel_color);
     dfs(image,cr-1,cc,color,pixel_color);
     dfs(image,cr,cc-1,color,pixel_color);
     dfs(image,cr+1,cc,color,pixel_color);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int pixel_color=image[sr][sc];
        if(color!=pixel_color)
        dfs(image,sr,sc,color,pixel_color);
        return image;
    }
}