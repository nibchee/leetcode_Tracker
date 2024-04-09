class Solution {
    public boolean canFinish(int n, int[][] p) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<p.length;i++){
            int u=p[i][0];
            int v=p[i][1];
            graph.get(v).add(u);
        }

int indegree[]=new int[n];
Queue<Integer> q =new LinkedList<>();
for(int i=0;i<n;i++){
    for(int j:graph.get(i))
    indegree[j]++;
}

for(int i=0;i<n;i++){
    if(indegree[i]==0)
    q.offer(i);
}

int courseCompleted=0;
while(!q.isEmpty()){
    int x=q.poll();
    courseCompleted++;
    for(int j:graph.get(x)){
        indegree[j]--;
        if(indegree[j]==0)
        q.add(j);
    }
}

if(courseCompleted==n)
return true;
      return false;  
    }
}