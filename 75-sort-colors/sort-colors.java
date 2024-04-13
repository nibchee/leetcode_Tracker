class Solution {
    public void sortColors(int[] nums) {
        //Just take 3 pointers
        int l=0,m=0,r=nums.length-1;
        while(m<=r){
            switch(nums[m]){
                case 0:
                  swap(nums,m,l);
                  m++;
                  l++;
                  break;
                case 1:
                 //just increment mid
                  m++;
                  break;
                case 2:
                  swap(nums,r,m);
                  r--;
            }
        }
    }

    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}