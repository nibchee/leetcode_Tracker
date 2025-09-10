class Solution {
    long c=1_000_000_007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long ans=0l;
        long a[][]=new long[n][forget];
        a[0][0]=1;
        for(int i=1;i<n;i++){
            long sum=0l;
            for(int j=forget-1;j>=1;j--){
                a[i][j]=a[i-1][j-1];
                if(j>=delay){
                    sum+=a[i][j];
                    sum=sum%c;
                }
            }
            a[i][0]=sum%c;
        }

        for(int i=0;i<forget;i++){
            ans+=a[n-1][i];
            ans=ans%c;
        }
    return (int)ans;
    }
}