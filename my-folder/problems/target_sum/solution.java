class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return recurse(nums, target, nums.length - 1);
    }

    public int recurse(int[] nums, int target, int idx){
        if(idx == 0){
            if(nums[idx] == 0 && target == 0){
                return 2; 
            }
            if(target - nums[idx] == 0){
                return 1;
            } else if(target + nums[idx] == 0){
                return 1;
            } else {
                return 0;
            }
        }
        int add = recurse(nums, target - nums[idx], idx - 1);
        int subtract = recurse(nums, target + nums[idx], idx - 1);
        return add + subtract;
    }
}