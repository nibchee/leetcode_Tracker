class Solution {
    private void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void sortColors(int[] nums) {
        int n=nums.length;
        int l=0,m=0,r=n-1;
        while(m<=r){
            switch(nums[m]){
                case 0:
                   swap(nums,m,l);
                   l++;
                   m++;
                   break;
                case 1:
                    m++;
                  break;
                case 2:
                swap(nums,m,r);
                r--;
                break;
            }
        }

    }


}