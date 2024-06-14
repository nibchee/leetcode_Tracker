class Solution {
    public String getPermutation(int n, int k) {
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
          arr[i]=i+1;
        }

        for(int i=1;i<k;i++){
          nextPermutation(arr);
        }
        String ans="";
        for(int i=0;i<n;i++){
          ans+=String.valueOf(arr[i]);
        }
        return ans;
    }
public void nextPermutation(int[] nums) {
        
    int n=nums.length-1;
    int pt=-1;
    for(int i=n;i>0;i--){
        if(nums[i]>nums[i-1]){
           pt=i-1;
           break;
        }
    }
   
    if(pt==-1)
    Arrays.sort(nums);
    else{
        int min_diff=Integer.MAX_VALUE;
        int second=-1;
        for(int i=pt+1;i<=n;i++){
            if(nums[i]-nums[pt] >0 && nums[i]-nums[pt]<min_diff){
               second=i;
               min_diff= nums[i]-nums[pt];
            }
        }

        int t=nums[pt];
        nums[pt]=nums[second];
        nums[second]=t;
            
        Arrays.sort(nums,pt+1,n+1);
    }
      
    }
}
