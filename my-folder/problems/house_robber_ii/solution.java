class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];
        for(int i = 0; i < nums.length; i++){
            if(i != nums.length - 1){
                nums1[i] = nums[i];
            }
            if(i != 0){
                nums2[i - 1] = nums[i];
            }
        }
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1, -1);
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2, -1);
        return Math.max(recurse(nums1, nums1.length - 1, dp1), recurse(nums2, nums2.length - 1, dp2));
    }

    public int recurse(int[] nums, int idx, int[] dp){
        if(idx < 0){
            return 0;
        }
        if(idx == 0){
            return nums[0];
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int take = nums[idx] + recurse(nums, idx - 2, dp);
        int notTake = recurse(nums, idx - 1, dp);
        return dp[idx] = Math.max(take, notTake);
    }
}