class Solution {
    public int maxSubArray(int[] nums) {
        int global_max = nums[0];
        int local_max = nums[0];
        for(int i = 1; i < nums.length; i++){
            local_max = Math.max(nums[i], nums[i] + local_max);
            global_max = Math.max(global_max, local_max);
        }
        return global_max;
    }
}