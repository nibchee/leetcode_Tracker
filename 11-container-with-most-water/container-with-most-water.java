class Solution {
    public int maxArea(int[] height) {
        
        int max_water=0;
        for(int i=0,j=height.length-1;i<j;){
            int current_water=(j-i)*Math.min(height[i],height[j]);
             max_water=Math.max(current_water,max_water);
            if(height[i]<height[j])
            i++;
            else
            j--;
        }
    return max_water;
    }
}