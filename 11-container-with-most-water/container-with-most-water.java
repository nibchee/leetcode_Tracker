class Solution {
    public int maxArea(int[] height) {
        //Here we need to just find max Water between 2 verticle lines
        //Simple Logic: Max Water= Length* Breadth
        
        int i=0;
        int j=height.length-1;
        int maxWater=0;
        while(i<j){
            maxWater=Math.max(Math.min(height[i],height[j])*(j-i),maxWater);
            if(height[i]<height[j])
            i++;
           else if(height[j]<height[i]){
            j--;
           }else{
            i++;
            j--;
           }
        }
    return maxWater;
    }
}