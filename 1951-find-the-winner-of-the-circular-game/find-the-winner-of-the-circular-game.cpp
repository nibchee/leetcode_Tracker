class Solution {
public:
    int findTheWinner(int n, int k) {
    vector<int> p(n, 0);
        int currPos = 0;
        int ones = 0;

        while (ones < n - 1) {
            int c = 0;
            while (c < k) {
                currPos = (currPos + n) % n;
                if (p[currPos] == 0)
                    c++;
                currPos++;
            }
            currPos = (currPos + n - 1) % n;
            p[currPos] = 1;
            ones++;
            while (p[currPos] == 1) {
                currPos++;
                currPos = (currPos + n) % n;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] == 0) {
                ans = i + 1;
                break;
            }
        }
        return ans;
         }

};