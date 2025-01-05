class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> ans=new ArrayList<>();
        HashSet<String> patterns=new HashSet<>();
           for(int i=0;i<=s.length()-10;i++){
            String s2=s.substring(i,i+10);
            if(patterns.contains(s2) && !ans.contains(s2)){
                ans.add(s2);
            }else{
                patterns.add(s2);
            } 
        }

        return ans;
    }
}
// //0 1 2 3 4 5 6 7 8 9 10