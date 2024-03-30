class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysAtmostK(nums,k)-subarraysAtmostK(nums,k-1);
    }

    private int subarraysAtmostK(int nums[],int k){
     HashMap<Integer,Integer> m=new HashMap<>();

     int count=0;
     int start=0;

     for(int end=0;end<nums.length;end++){
        m.put(nums[end],m.getOrDefault(nums[end],0)+1);

            while(m.size()>k){
             m.put(nums[start],m.get(nums[start])-1);
             if(m.get(nums[start])==0)
             m.remove(nums[start]);
            start++;
            }
             count+=(end-start+1);    
     }
        return count;
    }
}