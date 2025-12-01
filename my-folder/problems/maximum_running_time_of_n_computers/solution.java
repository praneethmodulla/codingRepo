class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long lo = 1;
        long sum = 0;
        for(int i = 0; i < batteries.length; i++){
            sum += batteries[i];
        }
        long high = sum/n;
        while(lo < high){
            long mid = high - (high - lo)/2;
            long extra = 0;
            for(int power : batteries){
                extra += Math.min(power, mid);
            } 
            if(extra >= (long)(n * mid)){
                lo = mid;
            } else {
                high = mid - 1;
            }
        } 
        return lo;
    }
}