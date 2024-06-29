class Solution {
public:
//    map<int,vector<int>>dp(1001);
    void findp(map<int,vector<int>>m,int i,set<int>&s){
        for(auto j:m[i]){
            if(s.insert(j).second){
            findp(m,j,s);
            }
        }
        //return ;
    }

      void findp(vector<vector<int>>&m,int i,set<int>&s){
        // if(m[i].size()==0){
        //     return ;
        // }
        for(auto j:m[i]){
            if(s.insert(j).second)
            findp(m,j,s);
        }
      //  return ;
    }

    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        //vector<set<int>>ans;
        //map<int,vector<int>>m;
        vector<vector<int>>v(n);
        //adjacency list
        for(int i=0;i<edges.size();i++){
           // m[edges[i][1]].push_back(edges[i][0]);
            v[edges[i][1]].push_back(edges[i][0]);
        }
        //finding parent
        vector<vector<int>> req(n);
        for(int i=0;i<n;i++){
            set<int>s;
            //findp(m,i,s);
            findp(v,i,s);
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