class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int currSum=0,subarrays=0;
        Map<Integer,Integer> prefixSum=new HashMap<>();
        prefixSum.put(currSum,1);

        for(int i=0;i<nums.length;i++){
            currSum+=nums[i]%2;
            if(prefixSum.containsKey(currSum-k)){
                subarrays+=prefixSum.get(currSum-k);
            }
            prefixSum.put(currSum,prefixSum.getOrDefault(currSum,0)+1);
        }
        return subarrays;
    }
}