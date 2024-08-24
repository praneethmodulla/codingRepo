class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            if(max < piles[i]){
                max = piles[i];
            }
        }
        if(h == piles.length){
            return max;
        }
        int low = 1;
        int high = max;
        int mid = 0;
        int ans = 1;
        while(low <= high){
            mid = (low + high)/2;
            long timeTaken = reqTime(mid, piles);
            if(timeTaken <= h){
                ans = mid;
                high = mid - 1;
            } else if(timeTaken > h){
                low = mid + 1;
            } 
        }
        return ans;
    }
    public long reqTime(int mid, int[] piles){
        long totalTime = 0;
        for(int i = 0; i < piles.length; i++){
            if(piles[i]%mid == 0){
                totalTime += piles[i]/mid;
            } else {
                totalTime += (piles[i]/mid) + 1;
            }
        }
        return totalTime;
    }
}