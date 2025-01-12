class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        
        int totalStones=aliceValues.length;
        int aliceScore=0;
        int bobScore=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return (b[0]+b[1])-(a[0]+a[1]);
        });
            
        for(int i=0;i<totalStones;i++){
            pq.add(new int[]{aliceValues[i],bobValues[i]});
        }
       

       while(!pq.isEmpty()){
           if(!pq.isEmpty())
           aliceScore+=pq.remove()[0];
           if(!pq.isEmpty())
           bobScore+=pq.remove()[1];
       }
     if(aliceScore>bobScore) return 1;
     if(aliceScore<bobScore) return -1;
     return 0;
     
    }
}