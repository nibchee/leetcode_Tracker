class Solution {
   // int INF=(int)1e9+7;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
       //Array of List
       int[][] shortestPaths=new int[n][n];


       for(int i=0;i<n;i++){
        bellman(n,edges,shortestPaths[i],i);
       }

       return getCity(n,shortestPaths,distanceThreshold);
    }

    void bellman(int n,int[][]edges,int[] shortestPath,int src){
        Arrays.fill(shortestPath,Integer.MAX_VALUE);
        shortestPath[src]=0;

        for(int i=1;i<n;i++){
    //relaxing edges n-1 times
    for(int[] edge:edges){
        int s=edge[0];
        int e=edge[1];
        int wt=edge[2];
        if(shortestPath[s]!=Integer.MAX_VALUE && shortestPath[s]+wt<shortestPath[e]){
        shortestPath[e]=shortestPath[s]+wt;
        } 
        if(shortestPath[e]!=Integer.MAX_VALUE && shortestPath[e]+wt<shortestPath[s]){
        shortestPath[s]=shortestPath[e]+wt;
        }
    }
    }
    }

    void dijkastra(int n,List<int[]>[] adjList,int []shortestPath,int src){
        PriorityQueue<int[]>q=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        q.add(new int[]{src,0});
        while(!q.isEmpty()){
            int[] cur=q.remove();
            int currCity=cur[0];
            int curDist=cur[1];
            if(curDist>shortestPath[currCity]) continue;

            for(int[] neighbour :adjList[currCity]){
                int nbh=neighbour[0];
                int wt=neighbour[1];
                if(shortestPath[nbh]>(curDist+wt)){
                    shortestPath[nbh]=curDist+wt;
                    q.add(new int[]{nbh,shortestPath[nbh]});
                }
            }
        }
    }

   int getCity(int n,int[][] shortPath,int threshold){
    int ans=-1;
    int fewCount=n;

    for(int i=0;i<n;i++){
        int c=0;
        for(int j=0;j<n;j++){
            if(i==j) continue;
            if(shortPath[i][j]<=threshold)
            c++;
        }

        if(c<=fewCount){
            fewCount=c;
            ans=i;
        }
    }
   return ans;
   }


}