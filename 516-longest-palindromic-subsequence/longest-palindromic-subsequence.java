class Solution {
    private String rev(String s){
        String res="";
        for(int i=s.length()-1;i>=0;i--){
           res+=s.charAt(i);
        } 
        return res;  
         }
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int prev[]=new int[n+1];
        int curr[];
        
        for(int j=0;j<=n;j++)
        prev[j]=0;

        for(int i=1;i<=n;i++){
            curr=new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s.charAt(n-j))
                curr[j]=1+prev[j-1];
                else
                curr[j]=Math.max(curr[j-1],prev[j]);
                //System.out.print(curr[j]);
            }
           // System.out.println();
        prev=curr;
        }
      return prev[n];
    }
}