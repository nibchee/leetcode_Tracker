class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
     ArrayList<ArrayList<Integer>> list=new ArrayList<>();
     for(int i=0;i<n;i++){
        list.add(new ArrayList<Integer>());
     }

     for(int[] edge:edges){
        list.get(edge[0]).add(edge[1]);
        list.get(edge[1]).add(edge[0]);
     }

     Queue<Integer> q=new LinkedList<>();
     q.add(source);
    boolean visited[]=new boolean[n];
     while(!q.isEmpty()){
        int node=q.remove();
        if(node==destination)
        return true;
        
        for(Integer i:list.get(node)){
            if(!visited[i]){
                visited[i]=true;
                q.add(i);
            }
        }
     }
return false;
    }
}