class Solution {
    public int numberOfAlternatingGroups(int[] color, int k) {
        int n=color.length;
        int linearColor[]=new int[2*n];
        for(int i=0;i<n;i++){
          linearColor[i+n]=linearColor[i]=color[i];
        }
        int c=0;
        int len=0;

        for(int i=0;i<n+k-1;i++){
          len=(i>0 && linearColor[i]!=linearColor[i-1])?len+1:1;
          if(len>=k) c++;
        }
        return c;
    }
}