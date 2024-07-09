class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n=customers.length;
        int start[]=new int[n];
        int finish[]=new int[n];
        int waitingTime[]=new int[n];

        start[0]=customers[0][0];
        finish[0]=start[0]+customers[0][1];
        long total_waiting_time=finish[0]-start[0];
        for(int i=1;i<customers.length;i++){
           if(finish[i-1]>customers[i][0]){
            start[i]=finish[i-1];
           }else{
            start[i]=customers[i][0];
           }
           finish[i]=start[i]+customers[i][1];
           total_waiting_time+=(finish[i]-customers[i][0]);
        }
    double ans=(double)total_waiting_time/n;
    return ans;
    }
}