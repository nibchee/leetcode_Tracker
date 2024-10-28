class Solution {
    int ans=0;
    public int longestSquareStreak(int[] nums) {
       Arrays.sort(nums);
      for(int i=0;i<nums.length;i++){
        try_all(nums,i,1);
      }
      return ans==1?-1:ans;
    }

    public void try_all(int nums[],int idx,int len){
      ans=Math.max(ans,len);
      long target=nums[idx]*nums[idx];
      int pos=findBS(nums,idx+1,nums.length-1,target);
      if(pos!=-1){
       try_all(nums,pos,len+1);
      }
    }

    public int findBS(int[] nums,int low,int high,long target){

        while(low<=high){
            int mid=low+(high-low)/2;
            if((long)nums[mid]==target){
                return mid;
            }else{
                if(target>(long)nums[mid]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}