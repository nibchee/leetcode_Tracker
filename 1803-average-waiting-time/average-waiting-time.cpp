class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
       int n = customers.size();
          int start[n]; 
        int finish[n] ;
        long total_waiting_time = 0;

        start[0] = customers[0][0];
        finish[0] = start[0] + customers[0][1];
        total_waiting_time = finish[0] - start[0];
        
        for (int i = 1; i < n; i++) {
            if (finish[i - 1] > customers[i][0]) {
                start[i] = finish[i - 1];
            } else {
                start[i] = customers[i][0];
            }
            finish[i] = start[i] + customers[i][1];
            total_waiting_time += (finish[i] - customers[i][0]);
        }
        
        double ans = (double)total_waiting_time / n;

       
        return ans;
    }
};