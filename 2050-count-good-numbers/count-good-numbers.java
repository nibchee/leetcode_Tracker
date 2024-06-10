class Solution {
    long MOD=1_000_000_007;
    public int countGoodNumbers(long n) {
        long d=n/2;
        long rem=n%2;
        long even=d+rem;
        long odd=d;
        long res1=pow(5,even)%MOD;
        long res2=pow(4,odd)%MOD;
        long res= (res1*res2)%MOD;
        return (int)res;
    }

    private long pow(long n,long p){
        long res=1;
        while(p>0){
            if(p%2==0){
               n=(n*n)%MOD;
               p=p/2;
            }else{
                res=(res*n)%MOD;
                p--;
            }
        }
        return res;
    }
}