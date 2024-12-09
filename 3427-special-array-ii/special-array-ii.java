class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean prefix[]=new boolean[nums.length];
        prefix[0]=true;
        for(int i=1;i<nums.length;i++){
           if(((nums[i]&1)==1 && (nums[i-1]&1)==1)||((nums[i]&1)==0 && (nums[i-1]&1)==0))  
               prefix[i]=false;
            else
                prefix[i]=true && prefix[i-1];
        }
        boolean ans[]=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            boolean P1=prefix[queries[i][0]];
            boolean P2=prefix[queries[i][1]];
            if((P1 && P2)||(!P1 && P2))
                ans[i]=true;
            else if(P1 && !P2)
                ans[i]=false;
            else
            ans[i]=isArraySpecial(nums,queries[i][0],queries[i][1]);
        }
        return ans;
    }
    
     public boolean isArraySpecial(int[] nums,int m,int n) {
        // System.out.println(m+" "+n);
        if(m-n+1==1)
            return true;
        for(int i=m;i<n;i++){
            //  System.out.println(nums.toString()+" "+i+" "+(i+1));
            if(((nums[i]&1)==1 && (nums[i+1]&1)==1)||((nums[i]&1)==0 && (nums[i+1]&1)==0))
                return false;
        }
    return true;
    }
}