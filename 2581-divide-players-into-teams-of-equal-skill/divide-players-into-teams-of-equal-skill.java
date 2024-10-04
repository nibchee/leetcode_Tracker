class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int  sum=0;
        for(int i=0;i<skill.length;i++){
               sum+=skill[i];
        }
  
    int teams=skill.length/2;
        if(sum%teams!=0)
            return -1;
        
        int pair_sum=sum/teams;
       
        long prd=1;
        long sum_prd=0;
        
        for(int i=0;i<teams;i++){
            prd=1;
            if(skill[i]+skill[skill.length-i-1]==pair_sum){
                prd=skill[i]*skill[skill.length-i-1];
                sum_prd+=prd;
            }else{
                return -1;
            }
        }
        return sum_prd;
    }
}