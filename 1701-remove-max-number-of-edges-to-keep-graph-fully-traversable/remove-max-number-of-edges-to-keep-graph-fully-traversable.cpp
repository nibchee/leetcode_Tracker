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
        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        }
        else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
};

class Solution {
public:
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
         DisjointSet dsAlice(n), dsBob(n);
        int totalEdges = 0;

        // Add type 3 edges first.
        for (const auto& edge : edges) {
            if (edge[0] == 3) {
                bool addedToAlice = dsAlice.findUPar(edge[1]) != dsAlice.findUPar(edge[2]);
                bool addedToBob = dsBob.findUPar(edge[1]) != dsBob.findUPar(edge[2]);
                if (addedToAlice) dsAlice.unionBySize(edge[1], edge[2]);
                if (addedToBob) dsBob.unionBySize(edge[1], edge[2]);
                if (addedToAlice || addedToBob) totalEdges++;
            }
        }

        // Add type 1 edges for Alice.
        for (const auto& edge : edges) {
            if (edge[0] == 1) {
                if (dsAlice.findUPar(edge[1]) != dsAlice.findUPar(edge[2])) {
                    dsAlice.unionBySize(edge[1], edge[2]);
                    totalEdges++;
                }
            }
        }

        // Add type 2 edges for Bob.
        for (const auto& edge : edges) {
            if (edge[0] == 2) {
                if (dsBob.findUPar(edge[1]) != dsBob.findUPar(edge[2])) {
                    dsBob.unionBySize(edge[1], edge[2]);
                    totalEdges++;
                }
            }
        }

        // Check if both Alice and Bob can traverse the entire graph.
        int aliceComponents = 0, bobComponents = 0;
        for (int i = 1; i <= n; ++i) {
            if (dsAlice.findUPar(i) == i) aliceComponents++;
            if (dsBob.findUPar(i) == i) bobComponents++;
        }

        if (aliceComponents > 1 || bobComponents > 1) return -1;
        return edges.size() - totalEdges;
    }
    
};