class Solution {

    private int findMaxinNthCol(int[][]mat,int col){
        int max=Integer.MIN_VALUE;
        int r=-1;
        for(int i=0;i<mat.length;i++){
            if(max<mat[i][col]){
                max=mat[i][col];
                r=i;
            }
        }
     return r;
    }

    public int[] findPeakGrid(int[][] mat) {
        int l=0;
        int h=mat[0].length-1;

        while(l<=h){
            int mid=l+(h-l)/2;
            int row=findMaxinNthCol(mat,mid);
            //System.out.println(mid+" "+row);
            //taking by default values as -1
            int left=mid-1>=0?mat[row][mid-1]:-1;
            int right=(mid+1)<=(mat[0].length-1)?mat[row][mid+1]:-1;

           //no need to check for below & upper row as they already small as its index of larger
            if(mat[row][mid]>left && mat[row][mid]>right){
                return new int[]{row,mid};
            }
            else if(mat[row][mid]>left){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
    return new int[]{-1,-1};
    }
}