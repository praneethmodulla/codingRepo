class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int sumWeights = 0;
        for(int i = 0; i < weights.length; i++){
            low = Math.max(low, weights[i]);
            sumWeights += weights[i];
        }
        int high = sumWeights;
        int mid = 0;
        int ans = 0;
        while(low <= high){
            mid = low + (high - low)/2;
            int numDays = reqDays(weights, mid);
            if(numDays <= days){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int reqDays(int[] weights, int mid){
        int totalDays = 1;
        int sum = 0;
        int rightPointer = 0;
        for(rightPointer = 0; rightPointer < weights.length; rightPointer++){
            if(sum + weights[rightPointer] > mid){
                totalDays += 1;
                sum = weights[rightPointer];
            } else {
                sum += weights[rightPointer];
            }
        }
        return totalDays;
    }
}