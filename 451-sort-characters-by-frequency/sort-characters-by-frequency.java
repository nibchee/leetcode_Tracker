class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> m=new HashMap<>();
        for(char ch:s.toCharArray()){
            m.put(ch,m.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Pair<Character,Integer>> pq=new PriorityQueue<>((x,y)->{
           return y.getValue()-x.getValue();
        });

    for(Map.Entry<Character,Integer> entry:m.entrySet()){
        pq.add(new Pair<Character,Integer>(entry.getKey(),entry.getValue()));
    }

    String ans="";
    while(!pq.isEmpty()){
 Pair<Character,Integer> p=pq.remove();
 for(int i=0;i<p.getValue();i++){
    ans+=p.getKey();
 }
    }
    return ans;
    }

}