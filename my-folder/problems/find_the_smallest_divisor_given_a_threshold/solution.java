class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        int low = 1;
        int high = max;
        int mid = 0;
        int ans = 1;
        while(low <= high){
            mid = (low + high)/2;
            int divVal = reqThresh(nums, mid);
            if(divVal <= threshold){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int reqThresh(int[] nums, int mid){
        int val = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]%mid == 0){
                val += nums[i]/mid;
            } else {
                val += nums[i]/mid + 1;
            }
        }
        return val;
    }
}