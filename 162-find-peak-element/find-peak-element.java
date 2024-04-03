class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
        return 0;
    
    //means length >2
    if(nums[0]>nums[1])
    return 0;

    if(nums[nums.length-1]>nums[nums.length-2])
    return nums.length-1;
     //Decreasing Search Space
     int lo=1;
     int hi=nums.length-2;

     while(lo<=hi){
          int mid=lo+((hi-lo)/2);

          if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
          return mid;
        
          if(nums[mid]<nums[mid+1]){
              lo=mid+1;
          }else{
              hi=mid;
          }
     }   
    return -1;
    }

}