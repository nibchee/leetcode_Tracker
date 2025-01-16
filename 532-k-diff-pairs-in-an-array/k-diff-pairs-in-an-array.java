class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,HashSet<Integer>> pairs=new HashMap<>();

        for(int num:nums){
           int num_plusK=num+k;
           int num_minusK=num-k;
          HashSet<Integer> s=pairs.get(num);
               
           if(pairs.containsKey(num_plusK)){
               if(pairs.get(num_plusK)==null || !pairs.get(num_plusK).contains(num)){
               if(s==null){
                s=new HashSet<>();
               }
               s.add(num_plusK);
               //System.out.println("Set"+s.toString());
               pairs.put(num,s);
               }
           }

           if(pairs.containsKey(num_minusK)){
            if(pairs.get(num_minusK)==null || !pairs.get(num_minusK).contains(num)){
               if(s==null){
                s=new HashSet<>();
               }
              s.add(num_minusK);
               pairs.put(num,s);
            }
           }

           if(s==null)
           pairs.put(num,null);
           //System.out.println(num+" "+pairs.get(num));
//System.out.println("-------------------------------");
        }
        //System.out.println(pairs.size());
       int ans=0;
        for(Map.Entry<Integer,HashSet<Integer>> entry: pairs.entrySet()){
           HashSet<Integer> set=entry.getValue();
           //System.out.println(entry.getKey()+" "+entry.getValue());
           if(set!=null){
            ans+=set.size();
           }
        }
        return ans;
    }
}