class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
       //Array of List
       List<int[]>[] adjList=new List[n];
       int[][] shortestPaths=new int[n][n];

       for(int i=0;i<n;i++){
        Arrays.fill(shortestPaths[i],Integer.MAX_VALUE);
        shortestPaths[i][i]=0;
        adjList[i]=new ArrayList<>();
       } 


       for(int[]edge:edges){
        int s=edge[0];
        int e=edge[1];
        int wt=edge[2];
        adjList[s].add(new int[]{e,wt});
        adjList[e].add(new int[]{s,wt});
       }

       for(int i=0;i<n;i++){
        dijkastra(n,adjList,shortestPaths[i],i);
       }

       return getCity(n,shortestPaths,distanceThreshold);
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