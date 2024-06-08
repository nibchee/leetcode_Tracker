class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixSum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
           prefixSum+=nums[i];
           int rem=prefixSum%k;
           System.out.println(rem);
           if(map.containsKey(rem)){
             if(i-map.get(rem)>=2) return true;
             }else
           map.put(rem,i); //keping first entry
        }
    return false;
    }
}