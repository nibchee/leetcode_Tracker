class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottle=numBottles;
        int ans=numBottles;
        while(emptyBottle>=numExchange){
            ans+=(emptyBottle/numExchange);
            emptyBottle=(emptyBottle/numExchange)+(emptyBottle%numExchange);
        }
    return ans;
    }
}