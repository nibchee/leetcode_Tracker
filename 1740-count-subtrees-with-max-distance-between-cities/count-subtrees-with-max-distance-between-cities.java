class Solution {
//below fn return validity + max Distance
    private int checkValidatyAndDiameter(int subtree,int[][]dist){
        int n=dist.length;
        int nodes=0,edges=0,diameter=0;
        //Iterating All nodes
        for(int i=0;i<n;i++){
            //Does Node present in current subtree
            if(((subtree>>i)&1)==0)continue;
            //if present so count node
            nodes++;
            for(int j=i+1;j<n;j++){
               if(((subtree>>j)&1)==0)continue;
                //This signifies its edge
                if(dist[i][j]==1){
                    edges++;
                }
            diameter=Math.max(diameter,dist[i][j]);
            }
        }
        //As here in Ques, Cities form a tree, so no subgraph
        return  (nodes==edges+1)? diameter:-1;
    }
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
     int dist[][]=new int[n][n];
     
     //fillig initial Matrix
     for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i]=0;
        }
     for(int edge[]:edges){
          dist[edge[0]-1][edge[1]-1]=dist[edge[1]-1][edge[0]-1]=1;
     }

     warshallAlgo(dist);
    //  for(int i=0;i<n;i++){
    //     for(int j=0;j<n;j++){
    //         System.out.print(dist[i][j]+" ");
    //     }
    //     System.out.println();
    //  }
     
     int ans[]=new int[n-1];
     for(int i=0;i<(1<<n);i++){
       int dia=checkValidatyAndDiameter(i,dist);
       if (dia>0) ans[dia-1]++;
       }
      return ans;
     }
     
    

    public void warshallAlgo(int[][] dist){
        int n=dist.length;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE)
                  dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
    }
}




/**
1.Observations:
->2<=n<=15
->Atleast n-1 edges 

2.Pseudo code
1.Calculate min Distance among all nodes
2.Generate all Subtrees using Bitmask
3.Check validity of each subtree & send Max Dist in that subtree

for eg:
0->000->0
1->001->1
2->010->1
3->011->2
4->100->1
5->101->2
6->110->2
7->111->3
8->1000->1


 */