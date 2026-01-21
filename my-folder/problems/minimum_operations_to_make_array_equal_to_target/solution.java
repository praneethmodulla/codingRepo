class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        long ops = 0;
        boolean prev = true;
        if(nums[0] > target[0]){
            prev = false;
            ops += nums[0] - target[0];
        } else {
            ops += target[0] - nums[0];
        }
        for(int i = 1; i < nums.length; i++){
            boolean check = true;
            if(nums[i] > target[i]){
                check = false;
            }
            if(check == prev){
                long prevSteps = Math.abs(target[i - 1] - nums[i - 1]);
                long currSteps = Math.abs(target[i] - nums[i]);
                ops += Math.max(currSteps - prevSteps, 0);
            } else {
                ops += Math.abs(target[i] - nums[i]);
            }
            prev = check;
        }
        return ops;
    }
}