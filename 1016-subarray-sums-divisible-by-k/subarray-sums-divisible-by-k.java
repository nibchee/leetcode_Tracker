class Solution {
    public int subarraysDivByK(int[] nums, int k) {
      int prefixSumMod=0;
        HashMap<Integer,LinkedList<Integer>> map=new HashMap<>();
        LinkedList<Integer> l=new LinkedList<>();
        l.add(-1);
        map.put(0,l);
        int c=0;
        for(int i=0;i<nums.length;i++){
           prefixSumMod=(prefixSumMod+nums[i])%k;
           if(prefixSumMod<0) prefixSumMod+=k;
        //   System.out.println(prefixSumMod);
           if(map.containsKey(prefixSumMod)){
             c+=map.get(prefixSumMod).size();    
             } 
           LinkedList<Integer> l2=map.getOrDefault(prefixSumMod,new LinkedList<Integer>());
           l2.add(i);
           map.put(prefixSumMod,l2);
        }
    return c;    
    }
}   