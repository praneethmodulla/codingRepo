class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 0;
        for(int i = 0; i < piles.length; i++){
            maxVal = Math.max(maxVal, piles[i]);
        }
        int low = 1;
        int high = maxVal;
        while(low <= high){
            int mid = (low + high)/2;
            long num = check(piles, mid);
            if(num > h){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    public long check(int[] piles, int eat){
        long numHours = 0;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] <= eat){
                numHours += 1;
            } else {
                if(piles[i]%eat == 0){
                    numHours += piles[i]/eat;
                } else {
                    numHours += (piles[i]/eat) + 1;
                }
            }
        }
        return numHours;
    }
}