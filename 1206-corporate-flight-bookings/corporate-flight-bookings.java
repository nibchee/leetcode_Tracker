class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans=new int[n];

        for(int i=0;i<bookings.length;i++){
            int s=bookings[i][0];
            int e=bookings[i][1];
            int v=bookings[i][2];
            ans[s-1]+=v;
            if(e<n) ans[e]+=-v;
        }

        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]+ans[i];
        }

        return ans;
    }
}