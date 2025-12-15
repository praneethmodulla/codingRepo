class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int start = 0;
        int end = 0;
        while(end < prices.length){
            if(end == 0){
                end++;
                continue;
            }
            while(end < prices.length && prices[end] + 1 == prices[end - 1]){
                end++;
            }
            if(end < prices.length && prices[end] + 1 != prices[end - 1]){
                long length = end - start;
                ans += ((length) * (length + 1))/2; 
                start = end;
            }
            if(end == prices.length){
                break;
            }
            end++;
        }
        long length = end - start;
        ans += ((length) * (length + 1))/2; 
        start = end;
        return ans;
    }
}