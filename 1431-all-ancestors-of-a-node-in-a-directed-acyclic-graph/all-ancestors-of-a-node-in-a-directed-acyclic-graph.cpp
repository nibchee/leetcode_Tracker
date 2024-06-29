class Solution {
public:
    set<int> findp(vector<int> m[], int i, set<int> dp[]) {
        // If the ancestors for the current node are already computed, return them
        if (!dp[i].empty()) {
            return dp[i];
        }

        // Recursively find ancestors
        set<int> s;
        for (auto j : m[i]) {
            s.insert(j);
            set<int> ancestors = findp(m, j, dp);
            s.insert(ancestors.begin(), ancestors.end());
        }

        // Store the computed ancestors in the dp array
        dp[i] = s;
        return s;
    }

    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        vector<int> v[n];
        // Build adjacency list
        for (int i = 0; i < edges.size(); i++) {
            v[edges[i][1]].push_back(edges[i][0]);
        }
        set<int> dp[n];
        vector<vector<int>> ans(n);

        // Find ancestors for each node
        for (int i = 0; i < n; i++) {
            set<int> s = findp(v, i, dp);
            ans[i] = vector<int>(s.begin(), s.end());
        }
        return ans;
    }
};
