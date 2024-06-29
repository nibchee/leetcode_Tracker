class Solution {
public:
    void findAncestors(vector<vector<int>>& adjList, int node, set<int>& ancestors) {
        for (auto parent : adjList[node]) {
            if (ancestors.insert(parent).second) {  // Only recurse if parent is newly inserted
                findAncestors(adjList, parent, ancestors);
            }
        }
    }

    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        vector<vector<int>> adjList(n);
        for ( auto& edge : edges) {
            adjList[edge[1]].push_back(edge[0]);
        }

        vector<vector<int>> result(n);
        for (int i = 0; i < n; ++i) {
            set<int> ancestors;
            findAncestors(adjList, i, ancestors);
            result[i] = vector<int>(ancestors.begin(), ancestors.end());
        }

        return result;
    }
};
