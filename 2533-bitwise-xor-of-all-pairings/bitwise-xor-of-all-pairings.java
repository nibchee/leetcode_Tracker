class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int l1=nums1.length%2;
        int l2=nums2.length%2;

        int ans=0;
        if(l1==1){
        for(int num:nums2){
            ans=ans^num;
        }
        }
        if(l2==1){
        for(int num:nums1){
            ans=ans^num;
        }
        }

        return ans;
    }
}