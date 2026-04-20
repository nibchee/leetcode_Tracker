class Solution {
    String sortString(String s) {
    char[] charArray = s.toCharArray();    
    Arrays.sort(charArray);                
    return new String(charArray);           
}
    public List<List<String>> groupAnagrams(String[] strs) {
        // Write your solution here
        HashMap<String,List<String>> anagramMap=new HashMap<>();

        for(String s: strs){
            String str=sortString(s);
            if(anagramMap.containsKey(str)){
               // System.out.println(s+" found");
            anagramMap.get(str).add(s);
            }else{
                //System.out.println(s+" not found");
                List<String> l=new ArrayList<>();
                l.add(s);
                anagramMap.put(str,l);
            }
            //System.out.println(anagramMap);
        }
        
         return new ArrayList<>(anagramMap.values()); // Return the lists of anagrams
    }
}