class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
      Arrays.sort(maximumHeight);
      int n=maximumHeight.length;
      int max=maximumHeight[n-1];
      long sum=0;
      int ht_assigned=max;
      for(int i=n-1;i>=0;i--){
        if(ht_assigned<=maximumHeight[i]){
          sum+=ht_assigned;
        }else{
          ht_assigned=maximumHeight[i];
          sum+=maximumHeight[i];
        }
        ht_assigned--;
        if(ht_assigned==0 && i>0){
          return -1;
        }
      }  
    return sum;
    }
}