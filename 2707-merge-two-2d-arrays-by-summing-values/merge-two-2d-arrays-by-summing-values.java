class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
      TreeMap<Integer,Integer> m=new TreeMap<>();
      for(int[] num:nums1){
        m.put(num[0],num[1]);
      }  

      for(int num[]: nums2){
        if(m.containsKey(num[0])){
            m.put(num[0],m.get(num[0])+num[1]);
        }else{
            m.put(num[0],num[1]);
        }
      }
      int ans[][]=new int[m.size()][2];
      int i=0;
      for(Map.Entry<Integer,Integer> entry:m.entrySet()){
         ans[i][0]=entry.getKey();
         ans[i++][1]=entry.getValue();
       
      }

      return  ans;
    }
}