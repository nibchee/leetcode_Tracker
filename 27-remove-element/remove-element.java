class Solution {
    public int removeElement(int[] nums, int val) {
      int i=0,j=0;
      int n=nums.length;
      while(j<n){
        while(i<n && nums[i]!=val){
          i++;
        }
        j=i;
        while(j<n && nums[j]==val){
          j++;
        }
        if(j<n){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        }
      }
        return i;
    }
}