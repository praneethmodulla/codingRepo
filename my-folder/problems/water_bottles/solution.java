class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        int rem = 0;
        int newFill = 0;
        while(numBottles > 0){
            ans += numBottles;
            newFill = (numBottles + rem)/numExchange;
            rem = (numBottles + rem) % numExchange;
            numBottles = newFill;
        }
        return ans;
    }
}