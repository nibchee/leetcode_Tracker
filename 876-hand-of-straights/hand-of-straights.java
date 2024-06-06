class Solution {
    public boolean isNStraightHand(int[] cards, int groupsize) {
         if(cards.length%groupsize!=0){
            return false;
        }
     
      //Using treeMap with O(nlogn)
      TreeMap<Integer,Integer> card_count=new TreeMap<>();
      //Storing frequency in sorted order
      for(int c:cards){
          if(card_count.containsKey(c)){
             card_count.replace(c,card_count.get(c)+1);
          }else{
              card_count.put(c, 1);
          }
      }


      while(card_count.size()>0){
        int min=card_count.firstKey();
        for(int i=min;i<min+groupsize;i++){
            if(!card_count.containsKey(i))
            return false;

          //decreasing count
          card_count.replace(i,card_count.get(i)-1);

          //removing if 0
          if(card_count.get(i)==0)
          card_count.remove(i);
        
        }
      }

return true;
    }
}