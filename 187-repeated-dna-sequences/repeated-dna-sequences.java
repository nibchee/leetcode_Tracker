class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> freq=new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            String s2=s.substring(i,i+10);
            freq.put(s2,freq.getOrDefault(s2,0)+1);
        }

        ArrayList<String> ans=new ArrayList<>();
        for(Map.Entry<String,Integer> entry: freq.entrySet()){
            if(entry.getValue()>1)
            ans.add(entry.getKey());
        }
        return ans;
    }
}
// //0 1 2 3 4 5 6 7 8 9 10