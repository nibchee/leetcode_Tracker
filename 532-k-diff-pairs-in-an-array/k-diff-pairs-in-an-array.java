class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0,r=1;
        int ans=0;
        int n=nums.length;
        while(l<n && r<n){
            if(l==r || nums[r]-nums[l]<k){
                r++;
            }else if(nums[r]-nums[l]>k){
                l++;
            }else{
                //equal
                l++;
                ans++;
                while(l<n && nums[l]==nums[l-1])
                l++;
            }
        }
        return ans;
    }
}