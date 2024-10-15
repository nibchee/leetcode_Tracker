class Solution {
    public long minimumSteps(String s) {

      int n=s.length();
      int zeros=0;
      long ans=0;
      for(int i=n-1;i>=0;i--){
        if(s.charAt(i)=='1')
        ans+=zeros;
        else
        zeros++;
      }
        return ans;
    }
}