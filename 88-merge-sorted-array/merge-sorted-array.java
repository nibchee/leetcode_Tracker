class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      if(n==0 ) return;
         int i=0,j=0;
         while(i<m && j<n){
           if(nums1[i]>nums2[j]){
              int temp=nums1[i];
              nums1[i]=nums2[j];
              int k=j;
              while(k+1<n && temp>nums2[k+1]){
                nums2[k]=nums2[k+1];
                k++;
              }
              nums2[k]=temp;
           }
           i++;
         }
        
         while(i<m+n){
           nums1[i]=nums2[i-m];
           i++;
         }
    }
}