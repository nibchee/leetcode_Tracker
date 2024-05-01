class Solution {
    public String reversePrefix(String word, char ch) {
    //    int idx=word.indexOf(ch);
      int idx=-1;
        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)==ch){
                idx=i;
                break;
            }
        }
        if(idx==-1)
        return word;

        String ans="";
        for(int i=idx;i>=0;i--){
            ans+=word.charAt(i);
        }

        for(int j=idx+1;j<word.length();j++){
            ans+=word.charAt(j);
        }
        return ans;
    }
}