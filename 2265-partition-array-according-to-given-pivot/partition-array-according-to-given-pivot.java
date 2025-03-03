class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> l=new ArrayList<>();
        ArrayList<Integer> g=new ArrayList<>();
        ArrayList<Integer> e=new ArrayList<>();
        for(int num:nums){
            if(num<pivot)
            l.add(num);
            if(num==pivot)
            e.add(num);
            if(num>pivot)
            g.add(num);
        }

        int ans[]=new int[nums.length];
        int i=0;
        for(Integer n:l){
            ans[i++]=n;
        }
        for(Integer n:e){
            ans[i++]=n;
        }
        for(Integer n:g){
            ans[i++]=n;
        }

        return ans;
    }
}