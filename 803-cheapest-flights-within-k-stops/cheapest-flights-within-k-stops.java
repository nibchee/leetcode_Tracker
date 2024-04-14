class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();

        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[] { flight[1], flight[2] });
        }

        int visited[] = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[src] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { src, 0 });
           k++;
        while(!queue.isEmpty() && k-->0){
            int size=queue.size();
            while(size-->0){
                int[] curr=queue.poll();
                int currNode=curr[0];
                int currPrice=curr[1];
                if(adj.containsKey(currNode)){
                    for(int[] neighbours: adj.get(currNode)){
                        int newPrice=currPrice+neighbours[1];
                        if(newPrice<visited[neighbours[0]]){
                            visited[neighbours[0]]=newPrice;
                            queue.offer(new int[]{neighbours[0],newPrice});
                        }
                    }
                }
            }
        }
        if(visited[dst]==Integer.MAX_VALUE)
        return -1;
        return visited[dst];
    }
}