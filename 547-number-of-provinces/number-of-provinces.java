class Solution {
    boolean []visited;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        visited=new boolean[n];
        int ans=0;
        for(int node=0;node<n;node++){
          //  System.out.println(node+" "+visited[node]);
            if(!visited[node]){
            dfs(node,isConnected);
            ans++;
            }
        }
        
 return ans;
    }

    public void dfs(int node,int[][] graph){
        visited[node]=true;

        for(int k=0;k<graph[node].length;k++){
            if(!visited[k] && graph[node][k]==1){
                dfs(k,graph);
            }
        }
    }
}