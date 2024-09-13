class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int prefixXOR[]=new int[arr.length];
        prefixXOR[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefixXOR[i]=prefixXOR[i-1]^arr[i];
        }
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            if(queries[i][0]==0){
              ans[i]=prefixXOR[queries[i][1]];
            }else{
                ans[i]=prefixXOR[queries[i][0]-1]^prefixXOR[queries[i][1]];
            }
        }
    return ans;
    }
}