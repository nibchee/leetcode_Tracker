class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        int  maxi=INT_MIN;
        for(int i=0;i<edges.size();i++){
            maxi=max({maxi,edges[i][0],edges[i][1]});
        }
        vector<vector<int>>adj(maxi+1);
        for(auto i : edges){
            adj[i[0]].push_back(i[1]);
            adj[i[1]].push_back(i[0]);
        }
        int n=adj.size();
        for(int i=1;i<=n;i++){
            int c=0;
            
            if(adj[i].size()==maxi-1){
                return i;
            }
        }
        return -1;
    }
};