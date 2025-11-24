class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int left = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i - 1] - 1 == prices[i]){
                continue;
            }
            long len = i - left;
            ans += (len) * (len + 1)/2;
            left = i;
        }
        long len = prices.length - left;
        ans += len * (len + 1)/2;
        return ans;
    }
}