class Solution {
    public int splitArray(int[] nums, int k) {
        int maxElement = Integer.MIN_VALUE;
        int sum = 0;
        if(nums.length < k){
            return -1;
        }
        for(int i = 0; i < nums.length; i++){
            if(maxElement < nums[i]){
                maxElement = nums[i];
            }
            sum += nums[i];
        }
        int low = maxElement;
        int high = sum;
        int mid = 0;
        int ans = 0;
        while(low <= high){
            mid = (low + high)/2;
            int numPartitions = reqPartitions(nums, mid);
            if(numPartitions > k){
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public int reqPartitions(int[] nums, int mid){
        int numPartitions = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] <= mid){
                sum += nums[i];
            } else {
                sum = nums[i];
                numPartitions += 1;
            }
        }
        return numPartitions + 1;
    }
}