class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int r=0,l=0;
        int ans=0;
        int n=nums.length;
        while(l<n && r<n){
            while(r<n && nums[r]-nums[l]<=2*k)
            r++;
            ans=Math.max(ans,r-l);
            l++;
        }
        return ans;
    }
}