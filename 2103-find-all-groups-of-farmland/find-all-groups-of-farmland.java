class Solution {
    //here as 0 or 1 so would mark as -1 for land visited
    public int[][] findFarmland(int[][] land) {
       ArrayList<int[]> list=new ArrayList<>();
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[i].length;j++){
                if(land[i][j]==1){
                    int[] ans=new int[4];
                    ans[0]=ans[2]=i;
                    ans[1]=ans[3]=j;
                    dfs(land,i,j,ans);
                    list.add(ans);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public void dfs(int[][]land,int i,int j,int ans[]){
        if(i<0 || j<0 || i>=land.length || j>=land[i].length || land[i][j]==-1 || land[i][j]==0){
               return;             
        }
        ans[0]=Math.min(ans[0],i);
        ans[1]=Math.min(ans[1],j);
        ans[2]=Math.max(ans[2],i);
        ans[3]=Math.max(ans[3],j);
    land[i][j]=-1;
    dfs(land,i+1,j,ans);
     dfs(land,i,j+1,ans);
      dfs(land,i-1,j,ans);
       dfs(land,i,j-1,ans);
    }
}