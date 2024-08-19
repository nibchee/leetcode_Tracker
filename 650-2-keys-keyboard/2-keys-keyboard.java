class Solution {
    public int minSteps(int N) {
       int ans=0;
       for(int i=2;i*i<=N;i++){
         int c=0;
         while(N%i==0){
             c++;
             N=N/i;
         }
      ans+=c*i;
       }
       if(N>1)
       ans+=N;
return ans;
    }
}