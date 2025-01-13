/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n=mountainArr.length();
        int peak=findPeak(mountainArr,n);
        //At first think of left
        //System.out.println(peak);
        int ans=-1;
        if(target>=mountainArr.get(0) && target<=mountainArr.get(peak)){
            ans=left_bs(0,peak,mountainArr,target);
        }
          if(ans==-1)      
            ans= right_bs(peak+1,n-1,mountainArr,target);
        

        return ans;
    }

    private int left_bs(int l,int h,MountainArray mountainArr,int target){
           while(l<=h){
            int mid=l+(h-l)/2;
            int mid_ele=mountainArr.get(mid);
            if(mid_ele==target)
            return mid;

            if(mid_ele<target){
                l=mid+1;
            }else{
                h=mid-1;
            }
         }
         return -1;
    }


  private int right_bs(int l,int h,MountainArray mountainArr,int target){
           while(l<=h){
            int mid=l+(h-l)/2;
            int mid_ele=mountainArr.get(mid);
            if(mid_ele==target)
            return mid;

            if(mid_ele<target){
                h=mid-1;
            }else{
                l=mid+1;
            }
         }
         return -1;
    }

    private int findPeak(MountainArray mountainArr,int n){
         if(mountainArr.get(0)>mountainArr.get(1))
         return 0;

         if(mountainArr.get(n-1)>mountainArr.get(n-2))
         return n-1;

         int l=1,h=n-2;
         while(l<=h){
            int mid=l+(h-l)/2;
            int mid_ele=mountainArr.get(mid);
            int mid_ele_1=mountainArr.get(mid+1);
            if(mid_ele>mountainArr.get(mid-1) && mid_ele>mid_ele_1)
            return mid;

            if(mid_ele<mid_ele_1){
                //search right
                l=mid+1;
            }else{
                h=mid-1;
            }
         }
         return -1;
    }
}