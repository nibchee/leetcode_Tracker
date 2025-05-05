class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0,j=0;
        int m=firstList.length;
        int n=secondList.length;
        ArrayList<int[]> ans=new ArrayList<>();

    while(i<m && j<n){
        int s=Math.max(firstList[i][0],secondList[j][0]);
        int e=Math.min(firstList[i][1],secondList[j][1]);
            if(s<=e){
                ans.add(new int[]{s,e});
            }
            
                if(firstList[i][1]<secondList[j][1])
                i++;
                else
                j++;
            }
        
   int [][]finalAns=new int[ans.size()][2];
   for(int z=0;z<ans.size();z++){
     finalAns[z]=ans.get(z);
   }
   return finalAns;
    }


}