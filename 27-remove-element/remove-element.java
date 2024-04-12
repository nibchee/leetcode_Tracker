class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0)
        return 0;
        if(nums.length==1){
            if(nums[0]==val)
            return 0;
            else 
            return 1;
        }

       int i=0,j=nums.length-1;
       while(i<j){
          
          while(i<j && nums[i]!=val){
            i++;
          }

          while(j>i && nums[j]==val){
            j--;
          }
          //swap both
          int temp=nums[i];
          nums[i]=nums[j];
          nums[j]=temp;
       }
return nums[i]!=val?i+1:i;
    }
}