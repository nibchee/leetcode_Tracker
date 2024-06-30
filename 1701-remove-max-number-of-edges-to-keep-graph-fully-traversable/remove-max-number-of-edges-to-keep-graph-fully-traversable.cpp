class DisjointSet {
    vector<int> rank, parent, size;

public:
    DisjointSet(int n) {
        rank.resize(n + 1, 0);
        parent.resize(n + 1);
        size.resize(n + 1);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findUPar(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findUPar(parent[node]);
    }

    void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v)
            return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        } else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v)
            return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
};

class Solution {
public:
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        DisjointSet aliceRoadsSet(n), bobRoadsSet(n);
        int numberOfedgesUsedToFormFinalSpanningTree = 0;

        // Add 3 type in Both as minimal Requirement
        for (auto& edge : edges) {
            if (edge[0] == 3) {
                if (aliceRoadsSet.findUPar(edge[1]) != aliceRoadsSet.findUPar(edge[2])) {
                    aliceRoadsSet.unionByRank(edge[1], edge[2]);
                    bobRoadsSet.unionByRank(edge[1], edge[2]);
                    numberOfedgesUsedToFormFinalSpanningTree++;
                }
            }
        }
       
       //Add 1 type for Alice
        for (auto& edge : edges) {
            if (edge[0] == 1) {
                if (aliceRoadsSet.findUPar(edge[1]) != aliceRoadsSet.findUPar(edge[2])) {
                    aliceRoadsSet.unionByRank(edge[1], edge[2]);
                    numberOfedgesUsedToFormFinalSpanningTree++;
                }
            }
        }

       //Add 2 type for Bob
        for (auto& edge : edges) {
            if (edge[0] == 2) {
                if (bobRoadsSet.findUPar(edge[1]) != bobRoadsSet.findUPar(edge[2])) {
                    bobRoadsSet.unionByRank(edge[1], edge[2]);
                    numberOfedgesUsedToFormFinalSpanningTree++;
                }
            }
        }
        //Now how can we find if union done or not if parent is same 
        //counting Alice elements whch are not in Set
         int numberOfAliceDisjointSets=0,numberOfBobDisjointSets=0;
        for(int i=1;i<=n;i++){
          if(aliceRoadsSet.findUPar(i)==i){
           numberOfAliceDisjointSets++;
          }
          if(bobRoadsSet.findUPar(i)==i){
            numberOfBobDisjointSets++;
          }
          if(numberOfAliceDisjointSets>1 || numberOfBobDisjointSets>1)
          return -1;
        }
            
        return edges.size() - numberOfedgesUsedToFormFinalSpanningTree;
    }
};