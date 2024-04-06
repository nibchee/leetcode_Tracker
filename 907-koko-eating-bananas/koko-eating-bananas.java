class Solution {

    private boolean possibleToEatInhHours(int piles[],int h,int eat_once){
        int count_hrs_taking=0;
        for(int i=0;i<piles.length;i++){
            count_hrs_taking+=(piles[i]/eat_once);
             if(piles[i]%eat_once!=0)
             count_hrs_taking++;
              if(count_hrs_taking>h)
              return false;
        }
             
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        //minimum Bananas Koko can eat i.e 1
        int min=1;
        //maximum Bananas Koko can eat- Max among all Piles
        int max=1;
        for(int i=0;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }
        int min_bananas=0;
        //so now have to check range of bananas min to max
        while(min<=max){
           int eat_atonce=min+(max-min)/2;
           //System.out.println(eat_atonce+" "+min+" "+max);
           if(possibleToEatInhHours(piles,h,eat_atonce)){
             min_bananas=eat_atonce;
             //try if he can eat more slower by reducing bananas
             max=eat_atonce-1;
           }else{
            //so increase speed of eating
            min=eat_atonce+1;
           } 
        }
        return min_bananas;
    }



}