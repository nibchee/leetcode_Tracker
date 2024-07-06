class Solution {
    public int passThePillow(int n, int time) {
      n=n-1;
        int pass=(int)Math.ceil((double)time/n);
        int rem=time%n;
     //   System.out.println(n+" "+pass+" "+rem);
         int ans=(rem==0)?n+1:rem+1;
        if(pass%2==0){
            
            ans=rem==0?1:n-rem+1;
        }
    return ans;
    }
}