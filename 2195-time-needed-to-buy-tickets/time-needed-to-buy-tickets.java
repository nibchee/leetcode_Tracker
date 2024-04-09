class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
      int time = 0;
        
        for (int i = 0; i < tickets.length; i++) {
            // If the current person is before or at the desired person 'k'
            if (i <= k) {
                time += Math.min(tickets[k], tickets[i]);
            } else {
                time += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        
        return time;
    }
   
}