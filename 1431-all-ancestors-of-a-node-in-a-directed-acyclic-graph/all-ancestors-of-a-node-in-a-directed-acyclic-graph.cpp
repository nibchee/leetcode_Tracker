class Solution {
public:
    set<int> findp(vector<int> m[], int i, set<int> dp[]) {
        if (!dp[i].empty()) {
            return dp[i];
        }

        set<int> s;
        for (auto j : m[i]) {
           if(s.insert(j).second){
            set<int> ancestors = findp(m, j, dp);
            s.insert(ancestors.begin(), ancestors.end());
           }
        }

        return dp[i] = s;
    
    }

    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        vector<int> v[n];
        for (int i = 0; i < edges.size(); i++) {
            v[edges[i][1]].push_back(edges[i][0]);
        }
        set<int> dp[n];
        vector<vector<int>> ans(n);

        for (int i = 0; i < n; i++) {
            set<int> s = findp(v, i, dp);
            ans[i] = vector<int>(s.begin(), s.end());
        }
        return ans;
    }
};
