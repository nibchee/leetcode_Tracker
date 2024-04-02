class Solution {
    public boolean isIsomorphic(String str1, String str2) {
          if(str1.length()!=str2.length())
        return false;

        HashMap<Character,Character> m=new HashMap<>();

        for(int i=0;i<str1.length();i++){
            if(!m.containsKey(str1.charAt(i))){
                m.put(str1.charAt(i),str2.charAt(i));
            }else{
                if(m.get(str1.charAt(i))!=str2.charAt(i))
                return false;
            }
        }
                   HashMap<Character,Character> m2=new HashMap<>();

        for(int i=0;i<str1.length();i++){
            if(!m2.containsKey(str2.charAt(i))){
                m2.put(str2.charAt(i),str1.charAt(i));
            }else{
                if(m2.get(str2.charAt(i))!=str1.charAt(i))
                return false;
            }
}
return true;
    }
}