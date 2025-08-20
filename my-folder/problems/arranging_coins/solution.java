class Solution {
    public int arrangeCoins(int n) {
        if(n == 1){
            return 1;
        }
        long low = 1;
        long high = n;
        while(low <= high){
            long mid = low + (high - low)/2;
            long sumMid = (mid * (mid + 1))/2;
            if(sumMid > n){
                high = mid - 1;
            } else if(sumMid < n){
                low = mid + 1;
            } else {
                return (int)mid;
            }
        }
        return (int)high;
    }
}