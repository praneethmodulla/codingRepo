class Solution {
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        int max = 0;
        for(int i = 0; i < candies.length; i++){
            max = Math.max(candies[i], max); 
        }
        int low = 1;
        int high = max;
        int ans = 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(check(candies, mid, k)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int[] candies, int mid, long k){
        long numPiles = 0;
        for(int i = 0; i < candies.length; i++){
            numPiles += candies[i]/mid;
        }
        if(numPiles >= k){
            return true;
        }
        return false;
    }
}