class Solution {
    public int findCenter(int[][] edges) {
        int common=0;
        for(int i=0;i<edges.length-1;i++)
        {
            if((edges[i][0]==edges[i+1][0])||(edges[i][0]==edges[i+1][1]))
                common=edges[i][0];
            else if((edges[i][1]==edges[i+1][0])||(edges[i][1]==edges[i+1][1]))
                common=edges[i][1];
        }
        return common;
    }
}