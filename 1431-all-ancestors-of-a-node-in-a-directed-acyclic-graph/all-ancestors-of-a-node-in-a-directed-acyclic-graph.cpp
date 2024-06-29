class Solution {
public:
    void findp(vector<int> m[], int i, set<int>& s, set<int> dp[]) {
        // if (!dp[i].empty()) {
        //     s.insert(dp[i].begin(), dp[i].end());
        //     return;
        // }

        for (auto j : m[i]) {
            if (s.insert(j).second)
                findp(m, j, s, dp);
        }
        //  dp[i] = s;
    }

    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        vector<int> v[n];
        // adjacency list
        for (int i = 0; i < edges.size(); i++) {
            v[edges[i][1]].push_back(edges[i][0]);
        }
        set<int> dp[n];
        // finding parent
        vector<vector<int>> ans(n);
        for (int i = 0; i < n; i++) {
            set<int> s;
            findp(v, i, s, dp);
            ans[i] = vector<int>(s.begin(), s.end());
        }
        return ans;
    }
};