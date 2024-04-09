class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
      int count=0;
    while(true){
        boolean finish=false;
        for(int i=0;i<tickets.length;i++){
            if(tickets[i]==0)
            continue;
            tickets[i]--;
            count++;
            if(tickets[k]==0){
                finish=true;
                break;
            }
        }
        if(finish)break;
    }
    return count;
    }
   
}