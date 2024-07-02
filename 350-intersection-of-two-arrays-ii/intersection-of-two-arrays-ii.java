class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int freq[]=new int[1001];
        for(int i=0;i<nums1.length;i++)
        freq[nums1[i]]++;

        ArrayList<Integer> ans=new ArrayList<>();
        for(int j=0;j<nums2.length;j++){
          if(freq[nums2[j]]>0){
            ans.add(nums2[j]);
            freq[nums2[j]]--;
          }
        }

       int[] arr = ans.stream().mapToInt(i -> i).toArray();
         return arr;

    }
}