class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return recurse(nums, nums.length - 1, target);
    }

    public int recurse(int[] nums, int idx, int target){
        if(idx == 0){
            if(target == 0 && nums[idx] == 0){
                return 2;
            }
            if(target - nums[idx] == 0){
                return 1;
            }
            if(target + nums[idx] == 0){
                return 1;
            }
            return 0;
        }
        int add = recurse(nums, idx - 1, target - nums[idx]);
        int subtract = recurse(nums, idx - 1, target + nums[idx]);
        return add + subtract;
    }
}