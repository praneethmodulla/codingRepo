class Solution {
    public int splitArray(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(nums[i], min);
            max += nums[i];
        }
        int low = min;
        int high = max;
        while(low <= high){
            int mid = (low + high)/2;
            int splits = check(nums, mid);
            if(splits > k){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int check(int[] nums, int mid){
        int sum = 0;
        int split = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > mid){
                return Integer.MAX_VALUE;
            }
            if(sum + nums[i] < mid){
                sum += nums[i];
            } else if(sum + nums[i] == mid){
                sum = 0;
                split++;
            } else {
                sum = nums[i];
                split++;
            }
        }
        if(sum > 0){
            split++;
        }
        return split;
    }
}