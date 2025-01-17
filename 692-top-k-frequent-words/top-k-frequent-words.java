class Solution {
    public List<String> topKFrequent(String[] words, int k) {
     HashMap<String,Integer> map=new HashMap<>();

     for(String s:words){
        map.put(s,map.getOrDefault(s,0)+1);
     } 

     PriorityQueue<Pair<String,Integer>> q=new PriorityQueue<>((a,b)->{
        if(a.getValue()==b.getValue()){
            return a.getKey().compareTo(b.getKey());
        }
        return b.getValue()-a.getValue();
     });
    for(Map.Entry<String,Integer> entry:map.entrySet()){
      q.add(new Pair(entry.getKey(),entry.getValue()));
    }

      List<String> ans=new ArrayList<>();
      int c=0;
      while(c<k){
       String str=q.remove().getKey();
       ans.add(str);
       c++;
      }

   return ans;     
    }
}