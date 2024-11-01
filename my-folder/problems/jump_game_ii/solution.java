class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return recurse(nums, 0, dp);
    }

    public int recurse(int[] nums, int idx, int[] dp){
        if(idx >= nums.length){
            return (int)Math.pow(10,9);
        }
        if(idx == nums.length - 1){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int numJumps = (int)Math.pow(10, 9);
        for(int i = 1; i <= nums[idx]; i++){
            if(idx + i < nums.length){
                numJumps = Math.min(numJumps, 1 + recurse(nums, idx + i, dp));
            }
        }
        return dp[idx] = numJumps;
    }
}