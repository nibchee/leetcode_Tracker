class Solution {
public:
//    map<int,vector<int>>dp(1001);
   void findAncestors(vector<vector<int>>& adjList, int node, set<int>& ancestors) {
        for (auto parent : adjList[node]) {
            if (ancestors.insert(parent).second) {  // Only recurse if parent is newly inserted
                findAncestors(adjList, parent, ancestors);
            }
        }
    }
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        //vector<set<int>>ans;
        vector<vector<int>>m(n);
        
        //adjacency list
        for(int i=0;i<edges.size();i++){
            m[edges[i][1]].push_back(edges[i][0]);
        }
        //finding parent
        vector<vector<int>> req(n);
        for(int i=0;i<n;i++){
            set<int>s;
            findAncestors(m,i,s);
            //ans.push_back(s);
             req[i]=vector<int>(s.begin(), s.end());
        }
        //converting into required data type for returning answer
        // vector<vector<int>> req;
        // for(int i=0;i<ans.size();i++){
        //     vector<int>v;
        //     for(auto j:ans[i]){
        //         v.push_back(j);
        //     }
        //     req.push_back(v);
        // }
        return req;
    }
};