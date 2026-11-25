class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character,Integer> freq=new HashMap<>();
        int n=secret.length();
        int bulls=0;
        int cows=0;
        String nonMatch="";
        //bulls
        for(int i=0;i<n;i++){
            char c1=secret.charAt(i);
            char c2=guess.charAt(i);
            //System.out.println(c1+" "+c2+" "+(c1==c2));
            if(c1==c2){
            bulls++;
            }
            else{
                nonMatch+=c2;
                freq.put(c1,freq.getOrDefault(c1,0)+1);
            }
        }
        //cows
        for(int i=0;i<nonMatch.length();i++){
            char ch=nonMatch.charAt(i);
            System.out.println(ch+" "+freq.containsKey(ch));
            if(freq.containsKey(ch)){
                cows++;
                freq.put(ch,freq.get(ch)-1);
                if(freq.get(ch)==0) freq.remove(ch);
            }
        }
        
       return Integer.toString(bulls)+'A'+Integer.toString(cows)+'B';
    }
}