class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        int n = customers.size();
        int start;
        int finish;
        long total_waiting_time = 0;

        start = customers[0][0];
        finish = start + customers[0][1];
        total_waiting_time = finish - start;

        for (int i = 1; i < n; i++) {
            if (finish > customers[i][0]) {
                start = finish;
            } else {
                start = customers[i][0];
            }
            finish = start + customers[i][1];
            total_waiting_time += (finish - customers[i][0]);
        }

        double ans = (double)total_waiting_time / n;

        return ans;
    }
};