class Solution {
    public boolean isVowel(char ch){
        return ch=='a'||ch=='i'||ch=='e'||ch=='o'||ch=='u';
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
      int flag[]=new int[words.length];
      for(int i=0 ;i<words.length;i++){
        String word=words[i];
        int len=word.length();
        if(isVowel(word.charAt(0)) && isVowel(word.charAt(len-1))){
            flag[i]=1;
        }
      }
      for(int i=1;i<words.length;i++){
         flag[i]=flag[i]+flag[i-1];
      }

      int ans[]=new int[queries.length];

      for(int i=0;i<queries.length;i++){
        int s=queries[i][0];
        int e=queries[i][1];
        if(s>0){
            ans[i]=flag[e]-flag[s-1];
        }else{
            ans[i]=flag[e];
        }


      }
   return ans;
    }
}