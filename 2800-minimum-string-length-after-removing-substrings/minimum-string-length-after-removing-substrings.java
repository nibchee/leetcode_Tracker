class Solution {
    public int minLength(String s) {
        int w=0;
        char[] charArray=s.toCharArray();

        for(int r=0;r<s.length();r++){
          charArray[w]=charArray[r];

          if(w>0 && (charArray[w-1]=='A' || charArray[w-1]=='C') && charArray[w]==charArray[w-1]+1)
          w--;
          else
          w++;
        }

        return w;
    }
}