class Solution {
    public boolean canArrange(int[] arr, int k) {
      int rem[]=new int[k];
      for(int i=0;i<arr.length;i++){
          rem[((arr[i]%k)+k)%k]++;
      }
    if(rem[0]%2!=0)
    return false;
      for(int i=1;i<=k/2;i++){
          if(rem[i]!=rem[k-i])
          return false;
      }
    return true;
    }
}